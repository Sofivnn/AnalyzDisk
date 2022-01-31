package com.SisNcom.DiskAnalyzer;

import java.sql.SQLException;

class AnalyzeDiskApplication {
    public static void main(String[] args) throws SQLException {
        DiskAnalyzer analyzer = new DiskAnalyzer();
        analyzer.analyserDisque();
        analyzer.afficherDisque();
    }
}