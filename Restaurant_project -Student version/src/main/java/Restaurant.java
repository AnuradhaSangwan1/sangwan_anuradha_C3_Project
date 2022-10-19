import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
  /
        this.menu.add(new Item("Lemon Rice",70));
        this.menu.add(new Item("Dosa Paneer",90));
    }
    
    

    public boolean isRestaurantOpen() {
        
    	int checkClosingTime = getCurrentTime().compareTo(this.closingTime);
        int checkOpeningTime = getCurrentTime().compareTo(this.openingTime);

        
        return checkClosingTime < 0 && checkOpeningTime >= 0;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

public LocalTime getOpeningTime() { return openingTime; }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() { return closingTime; }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }


    public List<Item> getMenu() {

    		return this.menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    public boolean isRestaurantOpen(){
        LocalTime time = LocalTime.now();
        int isStillOpen = time.compareTo(closingTime);
        int isOpen = time.compareTo(openingTime);
        if(isStillOpen<0&&isOpen>=0){
            return true;
        }
        return false;
    }



    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;

public int getOrderValue(List<Item> item){
        int totalValue = 0;
        for (Item myItem : item) {
            totalValue += myItem.getPrice();
        }
        return totalValue;
    
    }

}
