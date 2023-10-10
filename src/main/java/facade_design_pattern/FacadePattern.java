package facade_design_pattern;


import java.sql.Driver;

class Firefox //Firefox class represent specific web browsers
{
    public static Driver getFirefoxDriver()
    {
        return null; //method return null and print messages, but in a real scenario, they would perform actual actions related to the web browser
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Firefox Driver");
        //This class provides method to get a driver instance (getFirefoxDriver and getChromeDriver) and to generate HTML and JUnit reports (generateHTMLReport and generateJUnitReport
    }

    class Chrome //chrome class represent specific web browsers.
    {
        public static Driver getChromeDriver()
        {
            return null; //method return null and print messages, but in a real scenario, they would perform actual actions related to the web browser
        }

        public static void generateHTMLReport(String test, Driver driver)
        {
            System.out.println("Generating HTML Report for Chrome Driver");
        }

        public static void generateJUnitReport(String test, Driver driver)
        {
            System.out.println("Generating JUNIT Report for Chrome Driver");
        }
        //This class provides method to get a driver instance (getFirefoxDriver and getChromeDriver) and to generate HTML and JUnit reports (generateHTMLReport and generateJUnitReport
    }

    class WebExplorerHelperFacade //WebExplorerHelperFacade is the facade class
    {
        public static void generateReports(String explorer, String report, String test) //It provides a single method generateReports that takes parameters for the web browser (explorer
        {
            Driver driver = null;
            switch(explorer)
            {
                case "firefox":
                    driver = Firefox.getFirefoxDriver();
                    switch(report)
                    {
                        case "html":
                            Firefox.generateHTMLReport(test, driver);
                            break;
                        case "junit":
                            Firefox.generateJUnitReport(test, driver);
                            break;
                    }
                    break;
                case "chrome":
                    driver = Chrome.getChromeDriver();
                    switch(report)
                    {
                        case "html":
                            Chrome.generateHTMLReport(test, driver);
                            break;
                        case "junit":
                            Chrome.generateJUnitReport(test, driver);
                            break;
                    }
            }
            //we use swith and case, which means that the report type (report), and the test name (test). Inside the generateReports method, a driver is obtained based on the selected web browser, and the appropriate report generation method is called based on the report type
        }
    }

    public class FacadePattern {
        public static void main(String[] args) {
            String test = "CheckElementPresent"; // we demonstrate how to use the WebExplorerHelperFacade to generate reports for different browsers and report formats\

            WebExplorerHelperFacade.generateReports("firefox", "html", test);
            WebExplorerHelperFacade.generateReports("firefox", "junit", test);
            WebExplorerHelperFacade.generateReports("chrome", "html", test);
            WebExplorerHelperFacade.generateReports("chrome", "junit", test);
            //and we specify the test name, web browser ("firefox" or "chrome"), and report type ("html" or "junit"), and the facade handles the details of obtaining the driver and generating the report
        }
    }
}