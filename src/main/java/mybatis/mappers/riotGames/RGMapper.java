package mybatis.mappers.riotGames;

import mybatis.model.RiotGames.RGRoot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RGMapper {

    String INSERT_SUMMARY = ("INSERT INTO `mybatis-test`.`character_summary` (`name`, `title`) " +
            "VALUES (#{name}, #{title})");

    @Insert(INSERT_SUMMARY)
    public int insertSummary(RGRoot result);

}

