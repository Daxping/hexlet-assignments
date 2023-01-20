package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        Path absolutePath = Paths.get("src/main/resources/users.json").toAbsolutePath().normalize();
        byte[] fileContent = Files.readAllBytes(absolutePath);
        String content = new String(fileContent);
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> users = mapper.readValue(content, List.class);

        return users;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        PrintWriter pw = response.getWriter();
        List<Map<String, String>> users = getUsers();
        StringBuilder body  = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    </head>
                    <body>
                """);
        body.append("<table><tr>");
        for (Map<String, String> user : users) {
            body.append("<td>");
            body.append(user.get("id") + " ");
            body.append("</td><td><a href=/users/");
            body.append(user.get("id"));
            body.append(">");
            body.append(" " + user.get("firstName"));
            body.append(" ");
            body.append(user.get("lastName") + " ");
            body.append("</a></td>");
        }
        body.append("</tr></table>");
        pw.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        Map<String, String> vUser = new HashMap<>();
        for (Map<String, String> user : getUsers()) {
            if(user.get("id").equals(id)) {
                vUser = user;

            }
        }
        if (vUser.size() > 0) {
            PrintWriter pw = response.getWriter();
            StringBuilder body  = new StringBuilder();
            body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    </head>
                    <body>
                """);
            body.append("<table><tr>");
            body.append("<td>" + vUser.get("id") + " " + "</td>");
            body.append("<td>" + vUser.get("firstName") + " " +"</td>");
            body.append("<td>" + vUser.get("lastName") + " " + "</td>");
            body.append("<td>" + vUser.get("email") + "</td>");
            body.append("</tr></table>");
            pw.println(body);
        } else {
            response.sendError(404);
        }
        // END
    }
}
