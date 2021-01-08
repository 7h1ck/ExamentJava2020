package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import dao.utils.IDao;
import dao.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Employe;

/**
 *
 * @author DELL
 */
public class EmployeDao implements IDao<Employe>
{
    public List<Employe> employes;
    
    private String sql_create = "INSERT INTO `employe` (`fullName`,`dateEmbauche`, `idService`) VALUES (?, ?, ?)";
    private String sql_find_all_Retrait = "SELECT * FROM `employe` WHERE DateDiff(CURRENT_TIMESTAMP,dateEmbauche) >=65";
    private String sql_find_all_by_id = "SELECT * FROM `employe` WHERE `idService` = ?";    
    private String sql_find_all = "SELECT * FROM `employe`";
    

    

    public Employe save(Employe emp) {
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_create);
                ps.setString(1, emp.getFullName());
                ps.setDate(2, emp.getDateEmbauche()); 
                ps.setInt(3, emp.getIdService());                

                ps.executeUpdate();
                return emp;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }finally{
                //MyConnection.stop();
            }
        }
        return null;
    }

    @Override
    public Employe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employe> findBy(int id) {
        Connection c = MyConnection.getConnection();
        this.employes = new ArrayList<>();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_find_all_by_id);
                ps.setInt(1, id);
                
                ResultSet r = ps.executeQuery();
                while (r.next()){
                    this.employes.add(new Employe(r.getInt("id"),r.getString("fullName"),r.getDate("dateEmbauche")));
                }
            } catch (SQLException e) {
            }finally{
                //MyConnection.stop();
            }
        }
        return this.employes;
    }

    @Override
    public boolean remove(Employe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employe> findAll() {
        Connection c = MyConnection.getConnection();
        this.employes = new ArrayList<>();
        if (c != null) {
            try {
                Statement stat = c.createStatement();
                ResultSet r = stat.executeQuery(sql_find_all);
                while (r.next()){
                    this.employes.add(new Employe(r.getInt("id"),r.getString("fullName"),r.getDate("dateEmbauche")));
                    
                }
            } catch (SQLException e) {
            }finally{
                //MyConnection.stop();
            }
        }
        return this.employes;
    }

    public List<Employe> findAllRetrait() {
        Connection c = MyConnection.getConnection();
        this.employes = new ArrayList<>();
        if (c != null) {
            try {
                Statement stat = c.createStatement();
                ResultSet r = stat.executeQuery(sql_find_all_Retrait);
                while (r.next()){
                    this.employes.add(new Employe(r.getInt("id"),r.getString("fullName"),r.getDate("dateEmbauche")));
                    
                }
            } catch (SQLException e) {
            }finally{
                //MyConnection.stop();
            }
        }
        return this.employes;
    }


    
}