package databaseDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import curentstockDTO.StockManagementDTO;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasestockDAO {

    private Connection conn;
    private ResultSet rs;

    public DatabasestockDAO() {
        try {
            conn = new ConectionDAO().connectToDB();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasestockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getStock(StockManagementDTO objcurentstockdto) {
        try {
            String sqlCommand = "select * from products_stock where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sqlCommand);
            int id = objcurentstockdto.getIdItem();
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int stock = rs.getInt("stock_quantity");
                objcurentstockdto.setCurrentStock(stock);
            }
            pstm.close();
        } catch (SQLException error) {
            System.out.println("quantitystockDTO " + error);
        }
        return rs;
    }

    public void getItemFromStock(StockManagementDTO objcurentstockdto) {
        try {
            String sqlCommand = "update products_stock set stock_quantity = ? where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sqlCommand);
            int quantity = objcurentstockdto.getCurrentStock() - objcurentstockdto.getQuantity();
            pstm.setInt(1, quantity);
            pstm.setInt(2, objcurentstockdto.getIdItem());
            pstm.execute();
            pstm.close();
        } catch (SQLException error) {
            System.out.println("quantitystockDTO " + error);
        }
    }

    public void returnItemToStock(StockManagementDTO objcurentstockdto) {
        try {
            String sqlCommand = "update products_stock set stock_quantity = ? where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sqlCommand);
            this.getStock(objcurentstockdto);
            int quantity = objcurentstockdto.getCurrentStock() + 1;
            pstm.setInt(1, quantity);
            pstm.setInt(2, objcurentstockdto.getIdItem());
            pstm.execute();
            pstm.close();
        } catch (SQLException error) {
            System.out.println("quantitystockDTO " + error);
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasestockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
