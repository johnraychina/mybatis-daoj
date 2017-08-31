package your.project.dao;  //改为你工程的相应package

import your.project.vo.BasicVo;
import com.github.walker.mybatis.paginator.PageBounds;

import java.util.ArrayList;
import java.util.Map;

/**
 * mybatis DAO基类
 * <p/>
 * Created by HuQingmiao on 2015-5-29.
 */
public interface BasicDao<T extends BasicVo> {

    int save(T basicVo);

    int saveBatch(List<T> list);


    int update(T basicVo);

    int updateIgnoreNull(T basicVo);

    int updateBatch(List<T> list);


    int delete(T basicVo);

    int deleteBatch(List<T> list);

    int deleteByPK(Long id);

    int deleteAll();


    public long count();

    public BasicVo findByPK(Long id);

    public ArrayList<T> find(Map<String, Object> paramMap, PageBounds pageBounds);
}
