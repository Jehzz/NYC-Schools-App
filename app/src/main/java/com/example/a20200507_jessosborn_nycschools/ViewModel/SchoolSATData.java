package com.example.a20200507_jessosborn_nycschools.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchoolSATData {

    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    @SerializedName("num_of_sat_test_takers")
    @Expose
    private String numOfSatTestTakers;
    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    private String satCriticalReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    @Expose
    private String satMathAvgScore;
    @SerializedName("sat_writing_avg_score")
    @Expose
    private String satWritingAvgScore;

    public String getDbn() {
        return dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getNumOfSatTestTakers() {
        return numOfSatTestTakers;
    }

    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }


}