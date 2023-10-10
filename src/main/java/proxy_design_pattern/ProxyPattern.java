package proxy_design_pattern;

interface DatabaseExecuter //DatabaseExecuter is an interface
{
    public void executeDatabase(String query) throws Exception; //this  interface that defines the method executeDatabase(String query)
}

class DatabaseExecuterImpl implements DatabaseExecuter //DatabaseExecuterImpl is a concrete class that implements the DatabaseExecuter interface
{
    @Override
    public void executeDatabase(String query) throws Exception //It provides the actual implementation of executing a database query
    {
        System.out.println("Going to execute Query: " + query);
    }
}

class DatabaseExecuterProxy implements DatabaseExecuter //DatabaseExecuterProxy is a proxy class that also implements the DatabaseExecuter interface
{
    boolean ifAdmin; //It has a boolean ifAdmin to check if the user is an admin
    DatabaseExecuterImpl dbExecuter; //and an instance of DatabaseExecuterImpl to delegate the actual execution

    public DatabaseExecuterProxy(String name, String passwd) //DatabaseExecuterProxy constructor
    {
        if(name == "Admin" && passwd == "Admin@123")
        {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
        //it checks if the user is an admin by comparing the name and password. If the user is an admin, it sets ifAdmin to true
    }

    @Override
    public void executeDatabase(String query) throws Exception //In the executeDatabase method of the DatabaseExecuterProxy
    {
        if(ifAdmin)
        {
            dbExecuter.executeDatabase(query); // it first checks if the user is an admin (ifAdmin is true)
        }
        else
        {
            if(query.equals("DELETE"))
            {
                throw new Exception("DELETE not allowed for non-admin user"); //If the user is an admin, it directly delegates the execution to the DatabaseExecuterImpl
            }
            else
            {
                dbExecuter.executeDatabase(query); //Otherwise, it restricts certain queries, like "DELETE," for non-admin users by throwing an exception
            }
        }
    }
}

public class ProxyPattern
{
    public static void main(String[] args) throws Exception // in the main method, we demonstrate how the proxy works by creating instances of the proxy for both admin and non-admin users
    {
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE");

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE");

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");
        //we attempt to execute queries, including a "DELETE" query, to see how access control is enforced based on user privileges.
    }
}