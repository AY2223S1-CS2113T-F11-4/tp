import java.util.ArrayList;

public class PatientList {
    private ArrayList<Patient> patients;

    public PatientList() {
        patients = new ArrayList<>();
    }

    public void addPatient(String name, String birthDate, String gender, String id) {
        patients.add(new Patient(name, birthDate, gender, id));
    }

    public Patient findPatient(String id) {
        for (Patient patient: patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public void modifyPatientDetails(String id, String name, String birthDate, String gender) {
        Patient patientToBeModified = findPatient(id);
        if (patientToBeModified == null) {
            Messages.printLine();
            System.out.println("Sorry! No patient exists in the system with the supplied ID!");
            Messages.printLine();
        }
        Messages.printLine();
        if (!name.isEmpty()) {
            patientToBeModified.setName(name);
        }
        if (!birthDate.isEmpty()) {
            patientToBeModified.setBirthDate(birthDate);
        }
        if (!gender.isEmpty()) {
            patientToBeModified.setGender(gender);
        }
        System.out.println();
        System.out.println("The patient's details has been modified! Here are the new patient details!");
        System.out.println(patientToBeModified);
        Messages.printLine();
    }

    public boolean isEmpty() {
        return patients.size() == 0;
    }

    public int getTotalNumberofPatients() {
        return patients.size();
    }

    private Patient getPatient(int patientNumber) {
        return patients.get(patientNumber);
    }

    public void listPatients() {
        if (isEmpty()) {
            System.out.println("There are no patients in the system right now!");
            return;
        }
        System.out.println("Here are the list of patients in the system");
        for (int i = 0; i < getTotalNumberofPatients(); i++) {
            Messages.printLine();
            System.out.println((i + 1) + ")");
            System.out.println(getPatient(i));
        }
        Messages.printLine();

    }

}
