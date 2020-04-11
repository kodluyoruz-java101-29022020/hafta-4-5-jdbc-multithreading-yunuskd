package db.connection.mongo.connection;

import com.mongodb.MongoClient;

public class MongoDbConnection {

	private static MongoClient mongoClient;
	
	public static MongoClient getMongoDbConnection() {
		
		if(mongoClient == null) {
			mongoClient = new MongoClient("localhost", 27017);
		}
		return mongoClient;
	}
	
}
