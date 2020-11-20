import java.util.List;

public class AssassinManager 
{
	private AssassinNode killfront;
	private AssassinNode gravefront;
	
	public AssassinManager(List<String> names)
	{
		killfront=null;
		gravefront=null;
		AssassinNode killback=killfront;
		
		if(names.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		for(int i=0; i<names.size(); i++)
		{
			if(killfront==null)
			{
				killfront= new AssassinNode(names.get(i));
				killback= killfront;				
			}
			else
			{
				killback.next= new AssassinNode(names.get(i));
				killback=killback.next;
				
			}
			killback.next=null;
		}
		killback.next=killfront;
	}
	
	
	public void printKillRing()
	{		
		AssassinNode current=killfront;
		while(current!=null && current.next!=killfront)
		{
			System.out.println(current.name+" is stalking "+current.next.name);
			current=current.next;
		}
		System.out.println(current.name+" is stalking "+current.next.name);
	}
	
	
	public void printGraveyard()
	{
		AssassinNode current=gravefront;
		while(current!=null)
		{
			System.out.println(current.name+" was killed by "+current.killer);
			current=current.next;
		}
	}
	
	
	public boolean killRingContains(String name)
	{
		AssassinNode current = killfront;
		while(current!=null && current.next!=killfront)
		{
			if(name.toLowerCase().equals(current.name.toLowerCase()))
			{
				return true;
			}
			current=current.next;
					
		}
		return false;
	}
	
	
	public boolean graveyardContains(String name)
	{
		AssassinNode current = gravefront;
		while(current!=null)
		{
			if(name.toLowerCase().equals(current.name.toLowerCase()))
			{
				return true;
			}
			current=current.next;
					
		}
		return false;
	}
	
	
	public boolean gameOver()
	{
		return killfront.next==killfront;
	}
	
	
	public String winner()
	{
		if(this.gameOver())
		{
			return killfront.name;
		}
		else
		{
			return null;
		}
	}
	
	
	public void kill(String name)
	{
		AssassinNode current= killfront;
		AssassinNode graveback = gravefront;

		while(current!=null && current.next.name!=name)
		{
			current=current.next;
		}												
		AssassinNode temp = current.next;
		temp.killer=current.name;
		if(killfront.name==name)
		{
			killfront=killfront.next;
		}
		current.next=current.next.next;
		
		
		if(gravefront==null)
		{
			gravefront=temp;
			graveback=gravefront;					
		}
		else
		{
			while(graveback!=null && graveback.next!=null)
			{
				graveback=graveback.next;
			}
			graveback.next=temp;
			graveback=graveback.next;
		}
		graveback.next=null;
		
	}	
}
