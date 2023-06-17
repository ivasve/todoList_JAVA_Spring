
package com.unicorn.todoList;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
        import java.text.SimpleDateFormat;

public class DebugTests {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        String json = "{\"date\": \"21-12-2023\"}";  // dd-MM-yyyy format, should throw exception

        try {
            TodoListEntity todo = mapper.readValue(json, TodoListEntity.class);
            System.out.println(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

