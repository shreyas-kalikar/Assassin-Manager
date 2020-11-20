public class AssassinNode {
	
    public final String name; // this person's name (can't be changed)
    public String killer;     // name of who killed this person (null if alive)
    public AssassinNode next; // next node in the list

    public AssassinNode(String name) {
        
        this.name=name;
    
    }
    
    
    public AssassinNode(String name, AssassinNode next) { 
        this.name=name;
        this.next=next;
    }
    
    public AssassinNode(String name, AssassinNode next, String killer) { 
        this.name=name;
        this.next=next;
        this.killer = killer;
    }


}
