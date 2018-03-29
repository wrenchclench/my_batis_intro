package mybatis.mappers.rg;

import mybatis.model.rg.ChampionDto;
import mybatis.model.rg.StatsDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RGMapper {


    String INSERT_SUMMARY = ("INSERT INTO `mybatis-test`.`character_summary` (`id`,`name`, `title`) " +
            "VALUES (#{id}, #{name}, #{title})");
    String INSERT_STATS = ("INSERT INTO `mybatis-test`.`character_stats` (`id`, `attackdamage`, `armor`, `hp`, `attackrange`, `movespeed`) " +
            "VALUES (#{id}, #{attackdamage}, #{armor}, #{hp}, #{attackrange}, #{movespeed})");
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.character_summary where id = #{id}";
    String UPDATE_CHARACTER = "UPDATE `mybatis-test`.character_summary SET name = #{name}, " +
            "title = #{title} WHERE id = #{id}";
    String DELETE_CHARACTER = "DELETE FROM `mybatis-test`.character_summary WHERE id = #{id}";

    //GET
    @Select(GET_BY_ID)
    public ChampionDto getByID(int id);

    //CREATE FROM API/POST
    @Insert(INSERT_SUMMARY)
    public int insertSummary(ChampionDto result);

    @Insert(INSERT_STATS)
    public int insertStats(StatsDto stats);

    //UPDATE/PATCH
    @Update(UPDATE_CHARACTER)
    public int updateCharacter(ChampionDto character);

    //DELETE
    @Delete(DELETE_CHARACTER)
    public int deleteCharacter(int id);

}

