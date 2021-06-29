package dao;

import java.util.List;

public interface TopicDAO {

	long addTopic(Topic top);

	List<Topic> getTopic();
	
}
