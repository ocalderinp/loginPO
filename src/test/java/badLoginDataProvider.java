import org.testng.annotations.DataProvider;

public class badLoginDataProvider {

        @DataProvider(name = "badLogin")
        public Object [][] getDataFromDataprovider() {
            return new Object[][] {
                    {"Jhon Doe", "ThisIsNotAPasswor"},
                    {"Jhon ", ""},
                    {"Jhon","ThisIsNotAPassword"}
            };
        }

        @DataProvider(name = "addappointment")
    public Object [][] getDataFormAppointment(){
            return new Object[][]{
                    {"26/06/2019", "Comentario 1", "Medicaid", "Hongkong CURA Healthcare Center", true},
                    {"27/06/2019", "Comentario 2", "Medicare", "Tokyo CURA Healthcare Center", true},
                    {"28/06/2019", "Comentario 3", "None", "Seoul CURA Healthcare Center", false}
            };
        }
    }
