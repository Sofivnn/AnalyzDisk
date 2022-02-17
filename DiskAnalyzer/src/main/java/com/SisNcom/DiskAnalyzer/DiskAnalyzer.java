package com.SisNcom.DiskAnalyzer;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.sql.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DiskAnalyzer {

    private List<Disque> disques = new ArrayList<Disque>();

    public DiskAnalyzer(){}

    public void analyserDisque() {
        File[] disks;
        disks = File.listRoots();
        for(File disk:disks){
            Disque disque = new Disque(
                    disk,
                    ZonedDateTime.now(ZoneId.of("Europe/Paris")),
                    disk.getTotalSpace()
                    ,disk.getFreeSpace(),
                    disk.getUsableSpace()
            );
            disques.add(disque);
        }
    }

    public void afficherDisque() throws SQLException {
        for(Disque d : disques) {
            System.out.println(d);
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sisncom?serverTimeZone=UTC","root", "21042001");

                PreparedStatement statement = connection.prepareStatement
                        ("insert into diskstockage (nameDisk, total_disk_space, disk_free_space, disk_used_space, date) values (?,?,?,?,?);");
                statement.setString(1,  String.valueOf(d.getName()));
                statement.setLong(2, d.getEspaceTotale());
                statement.setLong(3, d.getEspaceLibre());
                statement.setLong(4, d.getEspaceUsed());
                statement.setString(5, String.valueOf(d.getDateAnalyze()));
                statement.execute();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
