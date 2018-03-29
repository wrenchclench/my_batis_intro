package mybatis.mappers.fc;


import mybatis.model.fc.SearchSummary;
import mybatis.model.fc.TopicSummary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FCMapper {

    //Insert Full Name, City and Country into SQL Table - fullcontact_searches
    String INSERT_CONTACT = ("INSERT INTO `mybatis-test`.`fullcontact_searches` (fullName, city, country) " +
            "VALUES ( #{fullName}, #{city}, #{country})");

    String INSERT_TOPIC = ("INSERT INTO `mybatis-test`.`fullcontact_topics` (topic) VALUES (#{topic})");

    String SELECT_TOPIC = ("SELECT * FROM `mybatis-test`.`fullcontact_topics` WHERE topic = #{topic}");


    @Insert(INSERT_CONTACT)
    public int insertContact(SearchSummary result);

    //Insert returned topics from PersonSummary into SQL table fullcontact_topics
    @Insert(INSERT_TOPIC)
    public int insertTopic(TopicSummary result);

    //Select topic from SQL Table fullcontact_topics
    @Select(SELECT_TOPIC)
    public TopicSummary selectTopic(String topic);
}
