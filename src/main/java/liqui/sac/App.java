package liqui.sac;

import java.io.File;
/**
 * Hello world!
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import java.sql.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;

public class App {
	public String handleRequest(Context context)throws SQLException, ClassNotFoundException, LiquibaseException {
		Liquibase liquibase = null;
		Properties prop = new Properties();
		try {
			Class.forName("org.postgresql.Driver");
			// load a properties file from class path, inside static method
			prop.load(App.class.getClassLoader().getResourceAsStream("db.properties"));

			// get the property value and print it out
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));

			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println(con);

			Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(con));
	        liquibase = new Liquibase("liquibase/db.changelog.xml", new ClassLoaderResourceAccessor(), database);
	        liquibase.update("");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
