package redis;

import redis.clients.jedis.Jedis;

public class KevinRedis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis redis = new Jedis();
		redis = new Jedis("127.0.0.1", 6379);
		
		redis.set("author", "kevingates");
		
		String data = redis.get("author");
		
		System.out.println(data);		
	}
}