package sit707_week5;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "223188749";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "KEMA SANKA SRINATH DISSANAYAKE GARUSINGHE ARACHCHIGE";
		Assert.assertNotNull("Student name is null", studentName);
	}

	
	 @Test
	    public void testTemperatureMin() {
	        System.out.println("+++ Running testTemperatureMin +++");
	        
	     // Initialise controller
			WeatherController wController = WeatherController.getInstance();
	        
	        // Arrange: Retrieve all the hours temperatures recorded as for today
	        int nHours = wController.getTotalHours();
	        double minTemperature = 1000;
	        
	        // Act: Find the minimum temperature
	        for (int i = 0; i < nHours; i++) {
	            // Hour range: 1 to nHours
	            double temperatureVal = wController.getTemperatureForHour(i + 1); 
	            if (minTemperature > temperatureVal) {
	                minTemperature = temperatureVal;
	            }
	        }
	        
	        // Assert: Compare with the minimum value cached in the controller
	        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.01); // Adjust delta as per precision
	        
	        System.out.println("+++ testTemperatureMin passed +++");
	    }
	 
	 @Test
	 public void testTemperatureMax() {
	     // Arrange
	     WeatherController wController = WeatherController.getInstance();
	     int nHours = wController.getTotalHours();
	     double maxTemperature = -1;

	     // Act
	     for (int i = 0; i < nHours; i++) {
	         double temperatureVal = wController.getTemperatureForHour(i + 1);
	         if (maxTemperature < temperatureVal) {
	             maxTemperature = temperatureVal;
	         }
	     }

	     double temperatureMaxFromCache = wController.getTemperatureMaxFromCache();

	     // Assert
	     Assert.assertTrue(temperatureMaxFromCache == maxTemperature);

	     // Clean up
	     wController.close();
	 }


	 @Test
	 public void testTemperatureAverage() {
	     // Arrange
	     WeatherController wController = WeatherController.getInstance();
	     int nHours = wController.getTotalHours();
	     double sumTemp = 0;

	     // Act
	     for (int i = 0; i < nHours; i++) {
	         double temperatureVal = wController.getTemperatureForHour(i + 1);
	         sumTemp += temperatureVal;
	     }
	     double averageTemp = sumTemp / nHours;
	     double cachedAverageTemp = wController.getTemperatureAverageFromCache();

	     // Assert
	     assertEquals("Average temperature should match cached value", cachedAverageTemp, averageTemp, 0.001);

	     // Clean up
	     wController.close();
	 }

	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
