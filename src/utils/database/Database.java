package utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";
	static final String USER = "sa";
	static final String PASS = "";

	static final String DB_URL_ONLINE = "jdbc:mysql://51.83.68.208/jeu3pc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String USER_ONLINE = "ptut";
	static final String PASS_ONLINE = "iutlaval2019";

	// Exécuter une requête SQL de sélection en LCOAL
	public Table executeQueryLocal(String query) {
		Connection conn = null;
		Statement stmt = null;
		Table table = null;

		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			ResultSet result = stmt.executeQuery(query);
			ResultSetMetaData resultMD = result.getMetaData();

			table = new Table();
			while (result.next()) {
				Ligne ligne = new Ligne();
				for (int i = 1; i <= resultMD.getColumnCount(); i++) {
					ligne.addValeur(result.getString(i));
				}
				table.addLigne(ligne);
			}

		} catch (SQLException se) {
			table = null;
			// se.printStackTrace();
		} catch (Exception e) {
			table = null;
			// e.printStackTrace();
		} finally {

			// Fermeture de statement et connection
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}

		return table;
	}

	// Exécuter une requête SQL de mise à jour en LOCAL
	public void executeUpdateLocal(String query) {
		Connection conn = null;
		Statement stmt = null;
		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fermeture de statement et connection
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Exécuter une requête SQL de mise à jour en LIGNE
	public void executeUpdateOnline(String query) {
		Connection conn = null;
		Statement stmt = null;
		try {

			conn = DriverManager.getConnection(DB_URL_ONLINE, USER_ONLINE, PASS_ONLINE);
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fermeture de statement et connection
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Exécuter une requête SQL de sélection en LIGNE
	public Table executeQueryOnline(String query) {
		Connection conn = null;
		Statement stmt = null;
		Table table = null;

		try {
			conn = DriverManager.getConnection(DB_URL_ONLINE, USER_ONLINE, PASS_ONLINE);
			stmt = conn.createStatement();

			ResultSet result = stmt.executeQuery(query);
			ResultSetMetaData resultMD = result.getMetaData();

			table = new Table();
			while (result.next()) {
				Ligne ligne = new Ligne();
				for (int i = 1; i <= resultMD.getColumnCount(); i++) {
					ligne.addValeur(result.getString(i));
				}
				table.addLigne(ligne);
			}

		} catch (SQLException se) {
			table = null;
			se.printStackTrace();
		} catch (Exception e) {
			table = null;
			e.printStackTrace();
		} finally {

			// Fermeture de statement et connection
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}

		return table;
	}

	public boolean canConnectOnline() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL_ONLINE, USER_ONLINE, PASS_ONLINE);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

}
