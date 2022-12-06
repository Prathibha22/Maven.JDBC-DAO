package daos;

import com.mysql.jdbc.Driver;
import com.sun.org.apache.xpath.internal.operations.Bool;
import models.DTOCar;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DAOCars implements DAOInterface{
    Connection conn;
    public DTOCar getCarFRomResultSet(ResultSet rs) throws SQLException {
        DTOCar objCar=new DTOCar();
        objCar.set_name(rs.getString("name"));
        objCar.set_make(rs.getString("make"));
        objCar.set_year(rs.getString("year"));
        objCar.set_color(rs.getString("color"));
        return objCar;
    }
    public DTOCar findById(int id) {
        conn=ConnectionFactory.getConnection1();
        try {
            PreparedStatement pstmt=conn.prepareStatement("select * from cars where id= ? ");
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            rs.beforeFirst();
            while(rs.next()){
                return getCarFRomResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Set<DTOCar> findAll() {
        conn=ConnectionFactory.getConnection1();
        try {
            PreparedStatement pstmt=conn.prepareStatement("select * from cars");
            ResultSet rs=pstmt.executeQuery();
            Set cars=new HashSet();
            rs.beforeFirst();
            while(rs.next()){
                DTOCar objCar=getCarFRomResultSet(rs);
                cars.add(objCar);
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }

    public Boolean create(DTOCar dto) {
        conn=ConnectionFactory.getConnection1();
        try {
            PreparedStatement pst=conn.prepareStatement("INSERT INTO CARS(NAME,MAKE,YEAR,COLOR) " +
                    "VALUES (?,?,?,?)");
            pst.setString(1,dto.get_name());
            pst.setString(2, dto.get_make());
            pst.setString(3,dto.get_year());
            pst.setString(4,dto.get_color());
            int status=pst.executeUpdate();
            conn.close();
            if (status==1)return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public Boolean update(DTOCar dto)
    {
        conn=ConnectionFactory.getConnection1();
        try {
            PreparedStatement pst=conn.prepareStatement("UPDATE CARS SET NAME=?,MAKE=?,YEAR=?,COLOR=? WHERE ID=?");
            pst.setString(1,dto.get_name());
            pst.setString(2, dto.get_make());
            pst.setString(3,dto.get_year());
            pst.setString(4,dto.get_color());
            pst.setInt(5,dto.get_id());
            int status=pst.executeUpdate();
            conn.close();
            if (status==1)return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Boolean delete(int id) {
        conn=ConnectionFactory.getConnection1();
        try {
            PreparedStatement pst=conn.prepareStatement("DELETE FROM CARS WHERE ID=?");
            pst.setInt(1,id);
            int status=pst.executeUpdate();
            conn.close();
            if (status==1)return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
