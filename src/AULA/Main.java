package AULA;

import DB.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        //
        try {
            Database database = new Database("osoby", "root", "");
            Object[] firstParams = {22, "Gali", 43, "PHP"};
            int uspech1 = database.insert("programatori", firstParams);
            System.out.println("Uložení uživatele = " + uspech1);

            Object[] params2 = {"Gali"};
            int uspech2 = database.delete("programatori", "jmeno = ?", params2);
            System.out.println("Smazaní uživatele Gali = " + uspech2);

            String[] columns = {"jmeno", "vek", "jazyk"};
            Object[] params = {"Galileo", 18, "Java", 6};
            int uspech4 = database.update("programatori", columns, "id = ?", params);
            System.out.println("Přepsání uživatele = " + uspech4);

            String[] columns3 = {"jmeno", "jazyk"};
            Object[] params3 = {"java"};
            ResultSet rs = database.select("programatori", columns3, "jazyk = ?", params3);

            while (rs.next()) {
                System.out.println(rs.getString("jmeno") + " - " + rs.getString("jazyk"));
            }
            System.out.println(database.count("programatori"));
        } catch (SQLException ex) {
            System.out.println("error - " + ex.getMessage());
        }
    }
}
