package your.project.vo;  //改为你工程的相应package

import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * PO 基类
 * <p/>
 * Created by HuQingmiao on 2015-5-13.
 */

import java.util.*;

/**
 * PO 基类
 * <p/>
 * Created by HuQingmiao on 2015-5-13.
 */
public abstract class BasicVo implements Serializable {


    public BasicVo() {
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    @Override
    public int hashCode()
    {
        int hashCode = 1;

        Field[] fields = this.getClass().getDeclaredFields();
        try
        {
            for( Field field : fields )
            {
                Object obj = field.get(this);
                hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return hashCode;
    }


    @Override
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }

        if (this.getClass() != o.getClass() )
        {
            return false;
        }

        Field[] thisFields = this.getClass().getDeclaredFields();
        Field[] oFields = o.getClass().getDeclaredFields();

        try
        {
            for( int i=0; i<thisFields.length; i++ )
            {
                if ("serialVersionUID".equals(thisFields[i].getName())) {
                    continue;
                }


                thisFields[i].setAccessible(true);
                oFields[i].setAccessible(true);
                Object thisValue = thisFields[i].get(this);
                Object oValue = oFields[i].get(o);
                if( !(thisValue == null ? oValue == null : thisValue.equals(oValue)) )
                {
                    return false;
                }
            }

        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }


        return true;
    }

}

