package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
/**
 * Classe de persistance des objets dans une base SQL
 * @author xavier
 *
 */
public abstract class Persistence {
	
	/**
	 * Méthode d'INSERT d'un nouveau médicament
	 * @param name le nom du nouveau médicament
	 * @param idForm l'identifiant de la forme du nouveau médicament
	 * @param patentDate la date d'obtention du brevet du nouveau médicament
	 * @throws SQLException l'exception SQL levée
	 */
	public static void insertMedicine(String name, int idForm, GregorianCalendar patentDate, int principeActif, int excipient) throws SQLException{
		Connection cn = Persistence.connection();
		Statement stmt;
		
		try{
			 stmt = cn.createStatement();
			 if(patentDate!=null)
				 stmt.executeUpdate("INSERT INTO medicament (nom,idForme,dateBrevet,principeActif,excipient) VALUES ('"+name+"',"+idForm+",'"+DatesConverter.dateToStringUS(patentDate)+"')");
			 else
				 stmt.executeUpdate("INSERT INTO medicament (nom,idForme,dateBrevet,principeActif,excipient) VALUES ('"+name+"',"+idForm+",null,"+principeActif+","+excipient+")");
		}catch (SQLException e){
			throw e;
		}
		finally{
			Persistence.closeConnection(cn);
		}
	}
	/**
	 * Méthode d'INSERT d'une nouvelle forme
	 * @param name le nom de la nouvelle forme
	 * @throws SQLException l'exception SQL levée
	 */
	public static void insertForm(String name) throws SQLException{
		Connection cn = Persistence.connection();
		Statement stmt;
		
		try {
			 stmt = cn.createStatement();
			stmt.executeUpdate("INSERT INTO forme (nom) VALUES ('"+name+"')");
		} catch (SQLException e) {
			throw e;
		}
		finally{
			Persistence.closeConnection(cn);
		}
	}

	/**
	 * Méthode de SELECT des tables
	 * @param table le nom de la table SQL à sélectionner
	 * @return un tableau à deux dimensions contenant tous les tuples de la table
	 * @throws SQLException l'exception SQL levée
	 */
	public static String[][] load(String table) throws SQLException{	
		//Déclaration des variables
		Connection cn = Persistence.connection();
		Statement stmt; 
		ResultSet rs = null;
		ResultSetMetaData metadata;
		int rowCount,columnCount,rowNum;
		String columnName;
		String[][] result = null;
		
	    try 
	    {
	    	stmt= cn.createStatement();
	    	//Définition de la requete pour construire le jeu d'enregistrement
	    	rs = stmt.executeQuery("SELECT count(*) FROM "+table);
			//Récupération du nombre de lignes du jeu d'enregistrement
	    	rs.next();
			rowCount=rs.getInt(1);
	    	//Définition de la requete pour construire le jeu d'enregistrement
	    	rs = stmt.executeQuery("SELECT * FROM "+table);
			metadata = rs.getMetaData();
			//Récupération du nombre de colonnes du jeu d'enregistrement
			columnCount = metadata.getColumnCount();
			//Déclaration du tableau qui contiendra toutes les informations
			result = new String[rowCount][columnCount];
			//PArcours du jeu d'enregistrement
			rowNum = 0;
	        while (rs.next()) 
	        {
	        	for (int numCol=0; numCol<columnCount; numCol++)
	        	{
	        		//Insertion de la valeur dans une case du tableau
	        		columnName = metadata.getColumnName(numCol+1);
		        	result[rowNum][numCol] = rs.getString(columnName);
	        	}
	        	rowNum++;
	        }
	        
		} catch (SQLException e) 
		{
			throw e;
		}
	    finally{
	    	Persistence.closeConnection(cn);
	    }
	return result;
	}

	/**
	 * Méthode de connexion à la BD
	 * @return une connexion active sur la BD
	 * @throws SQLException l'exception SQL levée
	 */
	private static Connection connection() throws SQLException{
//		String host = "192.168.222.72";
		String host = "127.0.0.1:3306";
		String base = "medoclab";
		String user = "root";
		String passwd = "";
		Connection conn = null;
		try
		{
//			String connectionString ="jdbc:sqlserver://"+host+";database="+base+";user="+user+";password="+passwd;
			String connectionString ="jdbc:mysql://"+host+"/"+base+"?user="+user+"&password="+passwd;
			conn = DriverManager.getConnection(connectionString);
		}
		catch (SQLException e) 
		{
			throw e;
		}
		return conn; 
	}
	
	/**
	 * Méthode de clôture de connexion
	 * @param conn la connexion à fermer
	 * @throws SQLException l'exception SQL levée
	 */
	private static void closeConnection(Connection conn) throws SQLException{
		try {
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * Méthode d'UPDATE d'un médicament
	 * @param name le nom du médicament à modifier
	 * @param idForm la nouvelle forme du médicament à modifier
	 * @param patentDate la nouvelle date d'obtention du brevet du médicament à modifier
	 * @param excipient 
	 * @param principeActif 
	 * @throws SQLException l'exception SQL levée
	 */
	public static void updateMedicine(String name, int idForm, GregorianCalendar patentDate, int principeActif, int excipient) throws SQLException {
		Connection cn = Persistence.connection();
		Statement stmt;
		try{
			 stmt = cn.createStatement();
			 stmt.executeUpdate("UPDATE medicament SET idForme="+idForm+", principeActif="+principeActif+", excipient="+excipient+" WHERE nom='"+name+"'");
			 if(patentDate!=null)
				 stmt.executeUpdate("UPDATE medicament SET dateBrevet='"+DatesConverter.dateToStringUS(patentDate)+"' WHERE nom='"+name+"'");
		}catch (SQLException e){
			throw e;
		}
		finally{
			Persistence.closeConnection(cn);
		}
	}

}
