package com.example;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping(path="/api",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertData(@RequestBody String rawJsonData,HttpServletRequest request) throws ParseException, IOException{
		JSONParser jparser=new JSONParser();
		Object jsonObj=jparser.parse(rawJsonData);
		JSONObject jObject=(JSONObject)jsonObj;
		
		FileWriter filewriter=new FileWriter(new File("C:\\Users\\Desktop\\Aayushi.txt"));
		filewriter.write(jObject.toJSONString());
		return rawJsonData;
		
	}
}
