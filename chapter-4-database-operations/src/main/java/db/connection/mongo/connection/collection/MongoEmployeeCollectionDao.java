package db.connection.mongo.connection.collection;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import db.connection.mongo.Main;
import db.connection.mongo.connection.MongoDatabaseManager;
import db.connection.mysql.connection.model.Employee;

public class MongoEmployeeCollectionDao {

	private MongoDatabase database;
	private String collectionName = "employees_document";
	
	public MongoEmployeeCollectionDao() {
		database = MongoDatabaseManager.getDB(Main.dbName);
		
		if(database.getCollection(collectionName) == null) {
			database.createCollection(collectionName);
		}
	}
	
	public boolean save(Employee employee) {
	
		try {
			
			MongoCollection<Document> collection = database.getCollection(collectionName);
			
			Document employeeDoc = new Document();
			employeeDoc.put("mysql_id", employee.getId());
			employeeDoc.put("name", employee.getName());
			employeeDoc.put("last_name", employee.getLastName());
			employeeDoc.put("gender", employee.getGender());
			employeeDoc.put("birthdate", employee.getBirthDate());
			employeeDoc.put("hiredate", employee.getHireDate());
			
			collection.insertOne(employeeDoc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public Document findByMySqlId(Long empNo) {
		
		MongoCollection<Document> collection = database.getCollection(collectionName);

		BasicDBObject query = new BasicDBObject();
		query.put("mysql_id", empNo);
		
		FindIterable<Document> cursor = collection.find(query);
		
		return cursor.iterator().next();
	}
	
}
