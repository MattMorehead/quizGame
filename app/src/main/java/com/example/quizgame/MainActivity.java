package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "name";
    private static final String[] constQuizQuestions = {"Congress shall make no law respecting an establishment of religion, or prohibiting the free exercise thereof; or abridging the freedom of speech, or of the press; or the right of the people peaceably to assemble, and to petition the Government for a redress of grievances.", "A well regulated Militia, being necessary to the security of a free State, the right of the people to keep and bear Arms, shall not be infringed.", "No Soldier shall, in time of peace be quartered in any house, without the consent of the Owner, nor in time of war, but in a manner to be prescribed by law.", "The right of the people to be secure in their persons, houses, papers, and effects, against unreasonable searches and seizures, shall not be violated, and no Warrants shall issue, but upon probable cause, supported by Oath or affirmation, and particularly describing the place to be searched, and the persons or things to be seized.", "No person shall be held to answer for a capital, or otherwise infamous crime, unless on a presentment or indictment of a Grand Jury, except in cases arising in the land or naval forces, or in the Militia, when in actual service in time of War or public danger; nor shall any person be subject for the same offence to be twice put in jeopardy of life or limb; nor shall be compelled in any criminal case to be a witness against himself, nor be deprived of life, liberty, or property, without due process of law; nor shall private property be taken for public use, without just compensation.", "In all criminal prosecutions, the accused shall enjoy the right to a speedy and public trial, by an impartial jury of the State and district wherein the crime shall have been committed, which district shall have been previously ascertained by law, and to be informed of the nature and cause of the accusation; to be confronted with the witnesses against him; to have compulsory process for obtaining witnesses in his favor, and to have the Assistance of Counsel for his defence.", "In Suits at common law, where the value in controversy shall exceed twenty dollars, the right of trial by jury shall be preserved, and no fact tried by a jury, shall be otherwise re-examined in any Court of the United States, than according to the rules of the common law.", "Excessive bail shall not be required, nor excessive fines imposed, nor cruel and unusual punishments inflicted.", "The enumeration in the Constitution, of certain rights, shall not be construed to deny or disparage others retained by the people.", "The powers not delegated to the United States by the Constitution, nor prohibited by it to the States, are reserved to the States respectively, or to the people."};
    private static final String[] constCorrectAnswers = {"AMENDMENT I", "AMENDMENT II", "AMENDMENT III", "AMENDMENT IV", "AMENDMENT V", "AMENDMENT VI", "AMENDMENT VII", "AMENDMENT VIII", "AMENDMENT IX", "AMENDMENT X"};
    private static final String[] constWrongAnswers = {"AMENDMENT I", "AMENDMENT II", "AMENDMENT III", "AMENDMENT IV", "AMENDMENT V", "AMENDMENT VI", "AMENDMENT VII", "AMENDMENT VIII", "AMENDMENT IX", "AMENDMENT X"};

    private static final String[] phyloQuizQuestions = {"Every man is a creature of the age in which he lives and few are able to raise themselves above the ideas of the time.", "No opinion is worth burning your neighbor for.", "Parents wonder why the streams are bitter, when they themselves poison the fountain.", "Revolt is the right of the people.", "Hell is truth seen too late.", "It's not the pace of life I mind. It's the sudden stop at the end.", "Consumption is the sole end and purpose of all production; and the interest of the producer ought to be attended to, only so far as it may be necessary for promoting that of the consumer.", "There is no art which one government sooner learns of another than that of draining money from the pockets of the people.", "I prefer liberty with danger than peace with slavery.", "Every man having been born free and master of himself, no one else may under any pretext whatever subject him without his consent. To assert that the son of a slave is born a slave is to assert that he is not born a man."};
    private static final String[] phyloCorrectAnswers = {"Voltaire", "Voltaire", "John Locke", "John Locke", "Thomas Hobbes", "Thomas Hobbes", "Adam Smith", "Adam Smith", "Jean-Jacques Rousseau", "Jean-Jacques Rousseau"};
    private static final String[] phyloWrongAnswers = {"Voltaire", "John Locke","Thomas Hobbes", "Adam Smith", "Jean-Jacques Rousseau",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, quizActivity.class);
        EditText editText = (EditText) findViewById(R.id.personName);
        String message = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("QUESTIONS", constQuizQuestions);
        intent.putExtra("ANSWERS", constCorrectAnswers);
        intent.putExtra("WRONGS", constWrongAnswers);

        startActivity(intent);
    }
    public void quizTwo(View view) {
        Intent intent = new Intent(this, quizActivity.class);
        EditText editText = (EditText) findViewById(R.id.personName);
        String message = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("QUESTIONS", phyloQuizQuestions);
        intent.putExtra("ANSWERS", phyloCorrectAnswers);
        intent.putExtra("WRONGS", phyloWrongAnswers);

        startActivity(intent);
    }



}