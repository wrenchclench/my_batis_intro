//package mybatis.controllers;
//
//import mybatis.model.ibmVisualRec.ClassifiedImages;
//import mybatis.services.WatsonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//
//@RequestMapping("/watson")
//public class WatsonVisualRecController {
//
//    @Autowired
//    WatsonService watsonService;
//
//    @RequestMapping("/image")
//    public ClassifiedImages classifyImages(@RequestParam(value = "query", defaultValue = "imageUrl") String query,
//                                          @RequestParam(value = "p", defaultValue = "true") boolean persist) {
//
//        return watsonService.classifyImages(query);
//    }
//
//}
