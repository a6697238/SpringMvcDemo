package com.houlu.JavaTest.SpringMvcDemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类名称: UserController <br>
 * 类描述: <br>
 *
 * @author lu.hou
 * @version 1.0.0
 * @since 16/10/6 上午10:37
 */
@Controller
@RequestMapping("/activiti")
public class ActivitiController {

    final String MODEL_ID = "modelId";
    final String MODEL_NAME = "name";
    final String MODEL_REVISION = "revision";
    final String MODEL_DESCRIPTION = "description";


    @RequestMapping("/model/{modelId}/json")
    @ResponseBody
    public Object json(@PathVariable("modelId") String modelId) {
        JSONObject object = new JSONObject();
        object.put(MODEL_ID, 13);
        object.put(MODEL_NAME, "ceshi");
        object.put("model", JSON.parseObject("{\"resourceId\":13,\"properties\":{\"process_id\":\"process\",\"name\":\"\",\"documentation\":\"\",\"process_author\":\"\",\"process_version\":\"\",\"process_namespace\":\"http://www.activiti.org/processdef\",\"executionlisteners\":\"\",\"eventlisteners\":\"\",\"signaldefinitions\":\"\",\"messagedefinitions\":\"\"},\"stencil\":{\"id\":\"BPMNDiagram\"},\"childShapes\":[{\"resourceId\":\"sid-4CC4E499-66D6-4414-B61C-D0522D425738\",\"properties\":{\"overrideid\":\"\",\"name\":\"\",\"documentation\":\"\",\"asynchronousdefinition\":\"false\",\"exclusivedefinition\":\"false\",\"sequencefloworder\":\"\"},\"stencil\":{\"id\":\"ExclusiveGateway\"},\"childShapes\":[],\"outgoing\":[],\"bounds\":{\"lowerRight\":{\"x\":415,\"y\":225},\"upperLeft\":{\"x\":375,\"y\":185}},\"dockers\":[]},{\"resourceId\":\"sid-6B9AD84A-A489-4571-83B1-F2D2901644D7\",\"properties\":{\"overrideid\":\"\",\"name\":\"\",\"documentation\":\"\",\"asynchronousdefinition\":\"false\",\"exclusivedefinition\":\"false\",\"executionlisteners\":\"\",\"multiinstance_type\":\"None\",\"multiinstance_cardinality\":\"\",\"multiinstance_collection\":\"\",\"multiinstance_variable\":\"\",\"multiinstance_condition\":\"\",\"isforcompensation\":\"false\",\"usertaskassignment\":\"\",\"formkeydefinition\":\"\",\"duedatedefinition\":\"\",\"prioritydefinition\":\"\",\"formproperties\":\"\",\"tasklisteners\":\"\"},\"stencil\":{\"id\":\"UserTask\"},\"childShapes\":[],\"outgoing\":[{\"resourceId\":\"sid-5C7B8EF4-B85A-4EFC-87EA-9791D683C07A\"}],\"bounds\":{\"lowerRight\":{\"x\":160,\"y\":245},\"upperLeft\":{\"x\":60,\"y\":165}},\"dockers\":[]},{\"resourceId\":\"sid-F2199145-6230-4E8A-95C2-0978E7C0299E\",\"properties\":{\"overrideid\":\"\",\"name\":\"\",\"documentation\":\"\",\"asynchronousdefinition\":\"false\",\"exclusivedefinition\":\"false\",\"executionlisteners\":\"\",\"multiinstance_type\":\"None\",\"multiinstance_cardinality\":\"\",\"multiinstance_collection\":\"\",\"multiinstance_variable\":\"\",\"multiinstance_condition\":\"\",\"isforcompensation\":\"false\",\"servicetaskclass\":\"\",\"servicetaskexpression\":\"\",\"servicetaskdelegateexpression\":\"\",\"servicetaskfields\":\"\",\"servicetaskresultvariable\":\"\"},\"stencil\":{\"id\":\"ServiceTask\"},\"childShapes\":[],\"outgoing\":[],\"bounds\":{\"lowerRight\":{\"x\":565,\"y\":260},\"upperLeft\":{\"x\":465,\"y\":180}},\"dockers\":[]},{\"resourceId\":\"sid-2B065534-7F4F-4742-8690-2309EB85F815\",\"properties\":{\"overrideid\":\"\",\"name\":\"\",\"documentation\":\"\",\"asynchronousdefinition\":\"false\",\"exclusivedefinition\":\"false\",\"executionlisteners\":\"\",\"multiinstance_type\":\"None\",\"multiinstance_cardinality\":\"\",\"multiinstance_collection\":\"\",\"multiinstance_variable\":\"\",\"multiinstance_condition\":\"\",\"isforcompensation\":\"false\",\"ruletask_rules\":\"\",\"ruletask_variables_input\":\"\",\"ruletask_exclude\":\"false\",\"ruletask_result\":\"\"},\"stencil\":{\"id\":\"BusinessRule\"},\"childShapes\":[],\"outgoing\":[{\"resourceId\":\"sid-B2CD6C21-BF19-4297-99B0-D3460DA502E9\"}],\"bounds\":{\"lowerRight\":{\"x\":325,\"y\":245},\"upperLeft\":{\"x\":225,\"y\":165}},\"dockers\":[]},{\"resourceId\":\"sid-5C7B8EF4-B85A-4EFC-87EA-9791D683C07A\",\"properties\":{\"overrideid\":\"\",\"name\":\"\",\"documentation\":\"\",\"conditionsequenceflow\":\"\",\"executionlisteners\":\"\",\"defaultflow\":\"false\"},\"stencil\":{\"id\":\"SequenceFlow\"},\"childShapes\":[],\"outgoing\":[{\"resourceId\":\"sid-2B065534-7F4F-4742-8690-2309EB85F815\"}],\"bounds\":{\"lowerRight\":{\"x\":224.37109375,\"y\":205},\"upperLeft\":{\"x\":160.62890625,\"y\":205}},\"dockers\":[{\"x\":50,\"y\":40},{\"x\":50,\"y\":40}],\"target\":{\"resourceId\":\"sid-2B065534-7F4F-4742-8690-2309EB85F815\"}},{\"resourceId\":\"sid-B2CD6C21-BF19-4297-99B0-D3460DA502E9\",\"properties\":{\"overrideid\":\"\",\"name\":\"\",\"documentation\":\"\",\"conditionsequenceflow\":\"\",\"executionlisteners\":\"\",\"defaultflow\":\"false\"},\"stencil\":{\"id\":\"SequenceFlow\"},\"childShapes\":[],\"outgoing\":[{\"resourceId\":\"sid-4CC4E499-66D6-4414-B61C-D0522D425738\"}],\"bounds\":{\"lowerRight\":{\"x\":375.25,\"y\":205},\"upperLeft\":{\"x\":325.6875,\"y\":205}},\"dockers\":[{\"x\":50,\"y\":40},{\"x\":20,\"y\":20}],\"target\":{\"resourceId\":\"sid-4CC4E499-66D6-4414-B61C-D0522D425738\"}}],\"bounds\":{\"lowerRight\":{\"x\":1200,\"y\":1050},\"upperLeft\":{\"x\":0,\"y\":0}},\"stencilset\":{\"url\":\"stencilsets/bpmn2.0/bpmn2.0.json\",\"namespace\":\"http://b3mn.org/stencilset/bpmn2.0#\"},\"ssextensions\":[]}"));
        object.put("description", "te");
        object.put("name", "te");
        return object;
    }

    @RequestMapping("/editor/stencilset")
    @ResponseBody
    public Object stencilset() {
        InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset-change.json");
        String str = "";
        try {
            str = IOUtils.toString(stencilsetStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}
