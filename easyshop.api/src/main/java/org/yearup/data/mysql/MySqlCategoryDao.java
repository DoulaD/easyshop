package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories()
    {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM category";


        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                Category category = mapRow(row);
                categories.add(category);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return categories;
    }
        // get all categories


    @Override
    public Category getById(int categoryId)
    {String sql = "SELECT * FROM category WHERE categoryId = ?";
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoryId);

            ResultSet row = statement.executeQuery();

            if (row.next())
            {
                return mapRow(row);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null;

    }
    // create a new category }
    @Override
    public Category create(Category category)
    { String sql = "INSERT INTO category(name, description,) " +
            " VALUES (?, ?);";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getName());
            statement.setString(1, category.getDescription());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys
                ResultSet generatedKeys = statement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    // Retrieve the auto-incremented ID
                    int newId = generatedKeys.getInt(1);

                    // get the newly inserted category
                    return getById(newId);
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null;
    }




    @Override
    public void update(int categoryId, Category category)
    {

            String sql = "UPDATE products" +
                    " SET name = ? " +
                    "WHERE category_id = ?";


            try (Connection connection = getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, category.getName());
                statement.setInt(2, category.getCategoryId());
                statement.setString(3, category.getDescription());

                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
    }

    // delete category

    @Override
    public void delete(int categoryId)
        {

            String sql = "DELETE FROM category " +
                    " WHERE categoryId = ?;";

            try (Connection connection = getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, categoryId);

                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }

        protected static Category mapRow(ResultSet row) throws SQLException
        {
            int categoryId = row.getInt("product_id");
            String name = row.getString("name");
            String description = row.getString("description");


            return new Category(categoryId,name,description);
        }
    }







