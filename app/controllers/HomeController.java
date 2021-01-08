package controllers;

import models.Estate;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class HomeController extends Controller {


    public Result index() throws SQLException
    {
        ArrayList users = fetch_data();
        return ok(views.html.index.render(users));

    }
    public ArrayList fetch_data() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        ResultSet rs;
        User u = new User();
        u.connection();
        rs = u.view();
        int i=0;
        while (rs.next())
        {
            i++;
            users.add(new User(rs.getString("name"),rs.getString("pswd"),i));
        }
           return  users;
    }
    public Result remove(String user_name) throws SQLException
    {
        User user =  new User();
        user.remove(user_name);
        ArrayList users = fetch_data();
        return ok(views.html.index.render(users));
    }




    public Result addEstates()
    {
        return ok(views.html.addEsates.render());
    }

//    public Result addToDb() {

//        DynamicForm requestData = DynamicForm.form().bindFromRequest();
//        String firstname = requestData.get("estate_name");
//
//        return ok("Hello " + firstname);


//        Estate estate =  new Estate();
//        try {
//            estate.insert();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return ok(views.html.add.render());
//    }


//    public Result modify(int dessert_id) {
//
//        return ok(views.html.modify.render());
//    }
//    public Result remove(String estate_id) throws SQLException
//    {
//        int id = Integer.parseInt(estate_id);
//        Estate estate =  new Estate();
//        estate.remove(id);
//        ArrayList estates = fetch_data();
//        return ok(views.html.view.render(estates));
//    }

}
