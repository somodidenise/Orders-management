package DataAccess;

import Connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(GenericDAO.class.getName());
    private final Class<T> type;
    protected abstract T extractObject(ResultSet rs) throws SQLException;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.type = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createInsertQuery(T object) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append("`"+type.getSimpleName().toLowerCase()+"`");
        query.append(" (");

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            query.append(field.getName()).append(",");
        }
        query.setLength(query.length() - 1);
        query.append(") VALUES (");
        for (Field field : fields) {
            query.append("?,");
        }
        query.setLength(query.length() - 1);
        query.append(")");

        return query.toString();
    }

    private String createSelectQuery(String field) {
        return "SELECT * FROM " + type.getSimpleName().toLowerCase() + " WHERE " + field + " = ?";
    }

    private String createDeleteQuery(String field) {
        return "DELETE FROM " + type.getSimpleName().toLowerCase() + " WHERE " + field + " = ?";
    }

    private String createUpdateQuery(T object, String idField) {
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(type.getSimpleName().toLowerCase());
        query.append(" SET ");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals(idField)) {
                query.append(field.getName()).append(" = ?,");
            }
        }
        query.setLength(query.length() - 1);
        query.append(" WHERE ").append(idField).append(" = ?");
        return query.toString();
    }

    public void insert(T object) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        try {
            String query = createInsertQuery(object);
            insertStatement = dbConnection.prepareStatement(query);
            Field[] fields = object.getClass().getDeclaredFields();
            int index = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                insertStatement.setObject(index++, field.get(object));
            }
            insertStatement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "GenericDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public T findById(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        T object = null;
        try {
            String query = createSelectQuery("id");
            findStatement = dbConnection.prepareStatement(query);
            findStatement.setInt(1, id);
            rs = findStatement.executeQuery();
           if(rs.next())
           {
               object = extractObject(rs);
           }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GenericDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return object;
    }

    public void deleteById(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            String query = createDeleteQuery("id");
            deleteStatement = dbConnection.prepareStatement(query);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GenericDAO:deleteById " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public void update(T object, int id) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            String query = createUpdateQuery(object, "id");
            updateStatement = dbConnection.prepareStatement(query);
            Field[] fields = object.getClass().getDeclaredFields();
            int index = 1;
            for (Field field : fields) {
                if (!field.getName().equals("id")) {
                    field.setAccessible(true);
                    updateStatement.setObject(index++, field.get(object));
                }
            }
            updateStatement.setObject(index, id);
            updateStatement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "GenericDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public String[][] findAll() {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + type.getSimpleName().toLowerCase();
            findAllStatement = dbConnection.prepareStatement(query);
            rs = findAllStatement.executeQuery();
            while (rs.next()) {
                list.add(extractObject(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GenericDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }

        Field[] fields = type.getDeclaredFields();
        String[][] data = new String[list.size()][fields.length];
        for (int i = 0; i < list.size(); i++) {
            T object = list.get(i);
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                try {
                    data[i][j] = String.valueOf(fields[j].get(object));
                } catch (IllegalAccessException e) {
                    LOGGER.log(Level.WARNING, "GenericDAO:findAll " + e.getMessage());
                }
            }
        }
        return data;
    }

    public String[] allIds() {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        List<Integer> ids = new ArrayList<>();
        try {
            String query = "SELECT id FROM " + type.getSimpleName().toLowerCase();
            findStatement = dbConnection.prepareStatement(query);
            rs = findStatement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GenericDAO:allIds " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        String[] data = new String[ids.size()];
        for(int i = 0; i < ids.size(); i++)
        {
            data[i] = String.valueOf(ids.get(i));
        }

        return data;
    }
}
