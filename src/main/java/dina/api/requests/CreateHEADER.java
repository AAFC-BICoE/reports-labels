package dina.api.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dina.LabelCreator.LabelCreator;
import dina.LabelCreator.Options.Options;
import spark.Request;
import spark.Response;

public class CreateHEADER{

	public String template;
	private Options op;
	private Request req;
	private Response res;
    private List<String> codesForCleanUp = new ArrayList<>();
	
	public CreateHEADER(Options options, Request request, Response response) {
		op = options;
		req = request;
		res = response;
	}

	public String result() throws IOException {
		   
			if(req.queryParams("template")!=null)
			   op.templateFile = op.templateDir+"/"+req.queryParams("template");
		
		   LabelCreator labels = new LabelCreator(op, req.queryParams("data"));
		   labels.baseURL = op.baseURL;
		   

           String re = labels.createHeaders();
           
		   return re;
	}
	
	public List<String> getCleanUp(){
		
		return codesForCleanUp;
	}
}
