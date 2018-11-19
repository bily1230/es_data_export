/**
 * 
 */
package com.chenhj.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**   
* Copyright: Copyright (c) 2018 Montnets
* 
* @ClassName: FileUtil.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: chenhj
* @date: 2018年11月17日 下午5:17:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年11月17日     chenhj          v1.0.0               修改原因
*/
public class FileUtil {
	/**
	 * 写文件
	 * @param data
	 * @throws IOException
	 */
	public static void writeFile(String file, String data) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			bw.write(data);
		} finally {
			if (bw != null) {
				bw.close();
			}
			if (fw != null) {
				fw.close();
			}
		}
	}
	/**
	 * 返回文件的行数
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static int getFileLine(String filePath) throws IOException{
		LineNumberReader  lnr = null;
		int line = 0;
		try {
			File file = new File(filePath);
			lnr = new LineNumberReader(new FileReader(file));
			lnr.skip(Long.MAX_VALUE);
			line = lnr.getLineNumber() + 1;
		} catch (Exception e) {
			throw e;
		}finally{
			if(lnr!=null){
				lnr.close();
			}
		}
		return line;
	}
	public static String fileRead(String filePath) throws Exception {
		 BufferedReader bReader =  null;
		try {
		File file = new File(filePath);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        String str = sb.toString();
        return str;
		} catch (Exception e) {
			throw e;
		}finally{
			if(bReader!=null){
				 bReader.close();
			}
		}
    }
	/**
	 *清空文件内容 
	 * @param fileName
	 * @throws IOException 
	 */
	public static void clearInfoForFile(String fileName) throws IOException {
			FileWriter fileWriter = null;
	        try {
	        	 File file =new File(fileName);
	            if(!file.exists()) {
	                file.createNewFile();
	            }
	            fileWriter = new FileWriter(file);
	            fileWriter.write("");
	            fileWriter.flush();
	        } catch (IOException e) {
	        	throw e;
	        }finally {
				if(fileWriter!=null){
					fileWriter.close();
				}
			}
	    }
	/**
	 * 查找不同的数据
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2= new ArrayList<>();
		for(String phone1:list1){
			if(!list2.contains(phone1)){
				System.out.println(111);
			}
		}
	}
}
