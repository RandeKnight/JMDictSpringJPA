package name.davie.andrew;

import java.lang.reflect.Field;

public class Utils {
	public void setIntField(String fieldName, int value)
	        throws NoSuchFieldException, IllegalAccessException {
	    Field field = getClass().getDeclaredField(fieldName);
	    field.setInt(this, value);
	}
	public static void setField(Object o,String fieldName, String value) {
		try {
	    Field field = o.getClass().getDeclaredField(fieldName);
	    field.set(o, value);
		} catch (NoSuchFieldException e) {
			//do nothing
		} catch (IllegalAccessException e) {
			System.out.println("Could not access field"+fieldName+" - change to protected?");
			
		}
	}
}
