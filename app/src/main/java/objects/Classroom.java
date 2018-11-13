package objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "class_room_table")
public class Classroom {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idClassRoom") // id de la clase
    private int idClassRoom;

    @NonNull
    @ColumnInfo(name = "classroom_name")  // Nombre del curso
    private String classroom_name;

    @NonNull
    @ColumnInfo(name = "studentsNumber") // cantidad de estudiantes
    private int studentsNumber;

    @NonNull
    @ColumnInfo(name = "classNumber") // Numero del aula
    private int classNumber;


    @NonNull
    @ColumnInfo(name = "tutor") // Nombre del tutor
    private String tutor;

   public Classroom(@NonNull int idClassRoom, @NonNull String classroom_name, @NonNull int studentsNumber, @NonNull int classNumber,@NonNull String tutor) {
        this.idClassRoom = 0; // Como el id es autonumerico lo seteamos a cero.
        this.classroom_name = classroom_name;
        this.studentsNumber = studentsNumber;
        this.classNumber = classNumber;
        this.tutor = tutor;
    }
    @NonNull
    public int getIdClassRoom() {
        return idClassRoom;
    }

    @NonNull
    public String getClassroom_name() {
        return classroom_name;
    }

    @NonNull
    public int getStudentsNumber() {
        return studentsNumber;
    }

    @NonNull
    public int getClassNumber() {
        return classNumber;
    }
    @NonNull
    public String getTutor() {
        return tutor;
    }

}
