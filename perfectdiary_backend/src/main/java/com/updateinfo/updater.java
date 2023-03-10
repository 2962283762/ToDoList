package com.updateinfo;

import com.Mapper.infosMapper;
import com.Obj.infoObj;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@WebServlet("/update")
public class updater extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        infoObj infoObj1 = new infoObj(req.getParameter("timestamp"),req.getParameter("text"),req.getParameter("username"),Boolean.valueOf(req.getParameter("isdelete")));
        String resource = "mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        infosMapper mapper = sqlSession.getMapper(infosMapper.class);
        mapper.insertInfo(infoObj1);
        sqlSession.close();


    }
}
