package adapter_design_pattern;

interface WebDriver //WebDriver is the target interface, which defines the getElement() and selectElement() methods.
{
    public void getElement();
    public void selectElement();
}

class ChromeDriver implements WebDriver //ChromeDriver is one of the classes that directly implements the WebDriver interface. It provides its own implementation of getElement() and selectElement() for the Chrome web browser.
{
    @Override
    public void getElement()
    {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement()
    {
        System.out.println("Select element from ChromeDriver");

    }

}

class IEDriver //IEDriver is another class that doesn't implement the WebDriver interface. Instead, it has its own methods findElement() and clickElement().
{
    public void findElement()
    {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver");
    }

}

class WebDriverAdapter implements WebDriver //WebDriverAdapter is the adapter class.
{
    IEDriver ieDriver;
    public WebDriverAdapter(IEDriver ieDriver) //It implements the WebDriver interface and has an instance of IEDriver
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() // The getElement() method of WebDriverAdapter calls findElement() of IEDriver
    {
        ieDriver.findElement();

    }

    @Override
    public void selectElement() //And the selectElement() method calls clickElement() of IEDriver.
    {
        ieDriver.clickElement();
    }
//This adapter allows an IEDriver object to be used as if it were a WebDriver.
}

public class AdapterPattern
{
    public static void main(String[] args) //In main method, we can see how the adapter pattern works by creating instances of ChromeDriver and IEDriver, and then using the WebDriverAdapter to adapt an IEDriver instance to the WebDriver interface
    {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement();
        //This allows I to call getElement() and selectElement() on the wID object, which internally delegates the calls to the IEDriver methods, making it compatible with the WebDriver interface.
    }
}