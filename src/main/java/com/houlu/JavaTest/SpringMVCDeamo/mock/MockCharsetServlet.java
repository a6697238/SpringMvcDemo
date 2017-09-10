package com.houlu.JavaTest.SpringMVCDeamo.mock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class threadTest
 */
public class MockCharsetServlet extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


        String characterEncoding = request.getCharacterEncoding();
        System.out.println(characterEncoding);

        System.out.println("Get");
        Map resMap=getParameterMap(request);
        String returnStr=new String();
        returnStr="map_:";
        Set<Object> rkeySet=resMap.keySet();
        System.out.println(rkeySet);
        if(!rkeySet.isEmpty()){
            for(Object key:rkeySet){
                returnStr=returnStr+key+":"+resMap.get(key)+",";
            }
            returnStr=returnStr.substring(0,returnStr.length()-1);

        }
        String re=new String(returnStr.getBytes("ISO-8859-1"),characterEncoding);
        System.out.println("re:"+re);

        response.setCharacterEncoding(characterEncoding);
        response.getWriter().write(re);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//
        String characterEncoding = request.getCharacterEncoding();
        System.out.println(characterEncoding);
//
        System.out.println("Post");
//		request.setCharacterEncoding("GBK");
        response.setCharacterEncoding(characterEncoding);
        Map resMap=getParameterMap(request);

        String returnStr=new String();
        returnStr="map_:";
        Set<Object> rkeySet=resMap.keySet();
        System.out.println(rkeySet);
        if(!rkeySet.isEmpty()){
            for(Object key:rkeySet){
                returnStr=returnStr+key+":"+resMap.get(key)+",";
            }
            returnStr=returnStr.substring(0,returnStr.length()-1);
        }
        System.out.println(returnStr);
        response.setCharacterEncoding(characterEncoding);
        response.getWriter().write(returnStr);
    }

    //把request的参数map转化成可读map
    @SuppressWarnings("rawtypes")
    public Map getParameterMap(HttpServletRequest request){
        Map properties=request.getParameterMap();
        Map returnMap=new HashMap();
        Iterator it=properties.entrySet().iterator();
        String key;
        String value=new String();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            key=(String)entry.getKey();
            Object valueObj=entry.getValue();
            if(valueObj==null){
                value="";
            }else if(valueObj instanceof String[]){
                String[] values=(String[])valueObj;
                for(String val:values){
                    value=val+",";
                }
                value=value.substring(0,value.length()-1);
            }else{
                value=valueObj.toString();
            }
            returnMap.put(key, value);
        }
        return returnMap;
    }
}
