//package com.unicorn.todoList;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/csrf")
//public class CsrfTokenController {
//
//    public ResponseEntity<Resource> csrf() {
//        Resource resource = new ClassPathResource("templates/csrf.html");
//        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(resource);
//    }
//}
//
//
