package Repo;

import java.io.IOException;
import java.sql.SQLException;

public interface DataSourceCRUD<T> {
    //CRUD - CREATE, READ, UPDATE, DELETE
    Integer create(T t) throws SQLException, IOException;

    T read(Integer id) throws SQLException, IOException;

    T update(T t) throws SQLException, IOException;

    void delete(Integer id) throws SQLException, IOException;


}
