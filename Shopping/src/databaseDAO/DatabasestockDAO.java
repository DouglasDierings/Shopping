package databaseDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import curentstockDTO.StockManagementDTO;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasestockDAO {

    private Connection conn; // Connection object for database connection
    private ResultSet rs; // ResultSet object for storing query results

    public DatabasestockDAO() {
        try {
            conn = new ConectionDAO().connectToDB(); // Establishes a connection to the database
        } catch (SQLException ex) {
            Logger.getLogger(DatabasestockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retrieves the stock information for a specific item from the database
     *
     * @param objcurentstockdto the stock management DTO object containing the
     * item ID
     * @return the result set containing the stock information
     */
    public ResultSet getStock(StockManagementDTO objcurentstockdto) {
        try {
            String sqlCommand = "SELECT * FROM products_stock WHERE id = ?";
            try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
                int id = objcurentstockdto.getIdItem();
                pstm.setInt(1, id);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int stock = rs.getInt("stock_quantity");
                    objcurentstockdto.setCurrentStock(stock);
                }
            }
        } catch (SQLException error) {
            System.out.println("quantitystockDTO " + error);
        }
        return rs;
    }

    /**
     * Updates the stock quantity of an item in the database
     *
     * @param objcurentstockdto the stock management DTO object containing the
     * item information
     */
    public void getItemFromStock(StockManagementDTO objcurentstockdto) {
        try {
            String sqlCommand = "UPDATE products_stock SET stock_quantity = ? WHERE id = ?";
            try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
                int quantity = objcurentstockdto.getCurrentStock() - objcurentstockdto.getQuantity();
                pstm.setInt(1, quantity);
                pstm.setInt(2, objcurentstockdto.getIdItem());
                pstm.execute();
            }
        } catch (SQLException error) {
            System.out.println("quantitystockDTO " + error);
        }
    }

    /**
     * Returns an item to the stock by updating the stock quantity in the
     * database
     *
     * @param objcurentstockdto the stock management DTO object containing the
     * item information
     */
    public void returnItemToStock(StockManagementDTO objcurentstockdto) {
        try {
            String sqlCommand = "UPDATE products_stock SET stock_quantity = ? WHERE id = ?";
            try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
                this.getStock(objcurentstockdto);
                int quantity = objcurentstockdto.getCurrentStock() + 1;
                pstm.setInt(1, quantity);
                pstm.setInt(2, objcurentstockdto.getIdItem());
                pstm.execute();
            }
        } catch (SQLException error) {
            System.out.println("quantitystockDTO " + error);
        }
    }

    /**
     * Closes the database connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasestockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
