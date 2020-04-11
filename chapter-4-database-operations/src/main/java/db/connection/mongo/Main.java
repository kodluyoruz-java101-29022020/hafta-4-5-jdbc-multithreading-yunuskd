package db.connection.mongo;

import db.connection.mongo.connection.MongoDatabaseManager;
import db.connection.mongo.connection.MongoDbConnection;

public class Main {

	public static String dbName = "employee";
	
	public static void main(String[] args) {
		
		// Get all database names
		MongoDbConnection.getMongoDbConnection().getDatabaseNames().forEach(System.out::println);
		
		MongoDatabaseManager.createDB(dbName);

		MongoDbConnection.getMongoDbConnection().close();
	}

}
