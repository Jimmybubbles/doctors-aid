package com.clinic.doctorsaid.database;

import java.sql.*;

import com.clinic.doctorsaid.model.Patient;

public class DatabaseManager {
    private Connection connect() {
        String url = "jdbc:sqlite:doctorsaid.db";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

// initialize database if it doesnt exist 

    public void initializeDatabase() {
    	String sql = "CREATE TABLE IF NOT EXISTS patients (" +
                 "id INTEGER PRIMARY KEY, " +
                 "name TEXT NOT NULL, " +
                 "medical_history TEXT)";
    	try (Connection conn = this.connect();
    			PreparedStatement pstmt = conn.prepareStatement(sql)) {
    			pstmt.executeUpdate();
    			System.out.println("Patients table created or already exists.");
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void addPatient(Patient patient) {
		String sql = "INSERT INTO patients(id, name, medical_history) VALUES(?,?,?)";
		try (Connection conn = this.connect();
			  PreparedStatement pstmp = conn.prepareStatement(sql)) {
			pstmp.setInt(1, patient.getID());
			pstmp.setString(2, patient.getName());
			pstmp.setString(3, patient.getMedicalHistory());
			pstmp.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
    }
}	