# Integration Test v2

## Arguments Parsing

 - **Case 1: No arguments are given**   
   *Input*:   
   $ java -jar sorting-tool.jar   
   
   *Output*:  
   Tue Dec 10 08:47:52 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 08:47:52 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 08:47:52 AEDT 2019::SEVERE::No arguments are given!  
   Tue Dec 10 08:47:52 AEDT 2019::INFO::**Use command "java -jar sorting-tool.jar -h" for instruction.**    
   
 - **Case 2: Non-indicator mode: One of arguments is not a head in the csv file**  
   *Input*:   
   $ java -jar sorting-tool.jar TryMe  
  
   *Output*:  
   Tue Dec 10 08:51:00 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 08:51:00 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 08:51:00 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 08:51:00 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 08:51:00 AEDT 2019::SEVERE::**No field named "TryMe" can be used for sorting!**  
    
   *Input*:   
   $ java -jar sorting-tool.jar ENTRY_NO EH_cm TryMe PH_cm
     
   *Output*:  
   Tue Dec 10 08:51:43 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 08:51:43 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 08:51:43 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 08:51:43 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 08:51:43 AEDT 2019::SEVERE::**No field named "TryMe" can be used for sorting!**   
   
 - **Case 3: Non-indicator mode: All arguments are the heads available in the csv file**  
   *Input*:   
   $ java -jar sorting-tool.jar ENTRY_NO EH_cm PH_cm  
   
   *Output*:  
   Tue Dec 10 08:52:36 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 08:52:36 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 08:52:36 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 08:52:36 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 08:52:36 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, EH_cm, PH_cm  
     
   output:  
   \- row: 2  
     &nbsp;&nbsp;column: 2  
     &nbsp;&nbsp;data: ENTRY_NO=46 EH_cm=160 PH_cm=280  
   \- row: 8  
     &nbsp;&nbsp;column: 9  
     &nbsp;&nbsp;data: ENTRY_NO=46 EH_cm=150 PH_cm=250  
   \- row: 6  
     &nbsp;&nbsp;column: 3  
     &nbsp;&nbsp;data: ENTRY_NO=45 EH_cm=128 PH_cm=189  
   
   Tue Dec 10 08:52:36 AEDT 2019::INFO::**All tasks are done.**  
   
 - **Case 4: Indicator mode: No arguments followed indicator -o**  
    *Input*:   
    $ java -jar sorting-tool.jar -o    
    
    *Output*:   
    Tue Dec 10 09:01:34 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:01:34 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:01:34 AEDT 2019::SEVERE::**No arguments are given for sorting!**  
    
 - **Case 5: Indicator mode: One argument followed indicator -o**  
   *Input*:   
   $ java -jar sorting-tool.jar -o TryMe   
    
   *Output*:  
   Tue Dec 10 09:06:17 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 09:06:17 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 09:06:17 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 09:06:17 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 09:06:17 AEDT 2019::SEVERE::**No field named "TryMe" can be used for sorting!**  
 
   *Input*:   
   $ java -jar sorting-tool.jar -o ENTRY_NO   
   
   *Output*:   
   Tue Dec 10 09:03:30 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 09:03:30 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 09:03:30 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 09:03:30 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 09:03:30 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO  
     
   output:  
   \- row: 2  
     &nbsp;&nbsp;column: 2  
     &nbsp;&nbsp;data: ENTRY_NO=46  
   \- row: 8  
     &nbsp;&nbsp;column: 9  
     &nbsp;&nbsp;data: ENTRY_NO=46  
   \- row: 4  
     &nbsp;&nbsp;column: 2  
     &nbsp;&nbsp;data: ENTRY_NO=45  
       
   Tue Dec 10 09:03:30 AEDT 2019::INFO::All tasks are done.     
   
 - **Case 6: Indicator mode: Multiple arguments followed indicator -o**  
   *Input*:   
   $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO EH_cm PH_cm    
      
   *Output*:  
   Tue Dec 10 09:09:34 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 09:09:34 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 09:09:34 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 09:09:34 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 09:09:34 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO, EH_cm, PH_cm  
     
   output:  
   \- row: 8  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068 ENTRY_NO=1 EH_cm=123 PH_cm=176  
   \- row: 3  
     &nbsp;&nbsp;column: 1  
     &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068 ENTRY_NO=1 EH_cm=93 PH_cm=134  
   \- row: 8  
     &nbsp;&nbsp;column: 10  
     &nbsp;&nbsp;data: DESIGNATION=ARZM 13 111 ENTRY_NO=2 EH_cm=145 PH_cm=222  
     
   Tue Dec 10 09:09:34 AEDT 2019::INFO::All tasks are done.    

 - **Case 7: Indicator mode: One argument followed indicator -o in reverse order**  
   *Input*:   
   $ java -jar sorting-tool.jar -o ENTRY_NO -r  
   
   *Output*:      
   Tue Dec 10 09:11:57 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 09:11:57 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 09:11:57 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 09:11:57 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 09:11:57 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO  
     
   output:  
   \- row: 3  
     &nbsp;&nbsp;column: 1  
     &nbsp;&nbsp;data: ENTRY_NO=1  
   \- row: 8  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: ENTRY_NO=1  
   \- row: 4  
     &nbsp;&nbsp;column: 6  
     &nbsp;&nbsp;data: ENTRY_NO=2  
     
   Tue Dec 10 09:11:57 AEDT 2019::INFO::All tasks are done.  
   
 - **Case 8: Indicator mode: Multiple arguments followed indicator -o in reverse order**  
   *Input*:   
   $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO EH_cm PH_cm -r    
      
   *Output*:   
   Tue Dec 10 09:15:36 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 09:15:36 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 09:15:36 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
   Tue Dec 10 09:15:36 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 09:15:36 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO, EH_cm, PH_cm  
     
   output:  
   \- row: 2  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=108 PH_cm=157  
   \- row: 6  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=152 PH_cm=230  
   \- row: 7  
     &nbsp;&nbsp;column: 7  
     &nbsp;&nbsp;data: DESIGNATION=SLP-312 ENTRY_NO=39 EH_cm=122 PH_cm=197  
   
   Tue Dec 10 09:15:36 AEDT 2019::INFO::All tasks are done.  
     
 - **Case 9: Indicator mode: Mix usage of -o, -r and -f, in different order**  
   *Input*:   
   $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO EH_cm -r -f input-data-ex.csv    
       
   *Output*:  
   Tue Dec 10 20:49:01 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 20:49:01 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 20:49:01 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
   Tue Dec 10 20:49:01 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 20:49:01 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO, EH_cm  
     
   output:  
   \- row: 2  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=108  
   \- row: 6  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=152  
   \- row: 7  
     &nbsp;&nbsp;column: 7  
     &nbsp;&nbsp;data: DESIGNATION=SLP-312 ENTRY_NO=39 EH_cm=122  
   
   Tue Dec 10 20:49:01 AEDT 2019::INFO::All tasks are done.   
   
   *Input*:   
   $ java -jar sorting-tool.jar -r -f input-data-ex.csv -o DESIGNATION ENTRY_NO EH_cm       
          
   *Output*:  
   Tue Dec 10 20:50:49 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 20:50:49 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 20:50:49 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
   Tue Dec 10 20:50:49 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
   Tue Dec 10 20:50:49 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO, EH_cm  
     
   output:  
   \- row: 2  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=108  
   \- row: 6  
     &nbsp;&nbsp;column: 4  
     &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=152  
   \- row: 7  
     &nbsp;&nbsp;column: 7  
     &nbsp;&nbsp;data: DESIGNATION=SLP-312 ENTRY_NO=39 EH_cm=122  
   
   Tue Dec 10 20:50:49 AEDT 2019::INFO::All tasks are done.  

 - **Case 10: Indicator mode: Some of arguments are out of the range of any indicators**  
   *Input*:   
   $ java -jar sorting-tool.jar ENTRY_NO -o DESIGNATION EH_cm -r -f input-data-ex.csv    
       
   *Output*:  
   Tue Dec 10 20:53:37 AEDT 2019::INFO::Welcome to use this sorting tool.  
   Tue Dec 10 20:53:37 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
   Tue Dec 10 20:53:37 AEDT 2019::SEVERE::**Unknown argument type for: *ENTRY_NO***  

## CSV File Reading  

  - **Case 1: Implicit filename: No file named "input-data.csv" in the same folder**   
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO  
    
    *Output*:  
    Tue Dec 10 09:19:31 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:19:31 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:19:31 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 09:19:31 AEDT 2019::SEVERE::**Input file "input-data.csv" does not exist!**  
    
  - **Case 2: Explicit filename: No file named as indicated in the same folder**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv
    
    *Output*:   
    Tue Dec 10 09:23:18 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:23:18 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:23:18 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:23:18 AEDT 2019::SEVERE::**Input file "input-data-ex.csv" does not exist!**  
    
  - **Case 3: The content of the file indicated is empty**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv
  
    *Output*:   
    Tue Dec 10 09:27:47 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:27:47 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:27:47 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:27:47 AEDT 2019::SEVERE::**Data read from file "input-data-ex.csv" is empty!**  
    Tue Dec 10 09:27:47 AEDT 2019::SEVERE::Read process of "input-data-ex.csv" is incomplete!  
    
  - **Case 4: The file indicated only contains one row, i.e. the heads**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv  
    
    *Output*:   
    Tue Dec 10 09:28:30 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:28:30 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:28:30 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:28:30 AEDT 2019::SEVERE::**Data read from file "input-data-ex.csv" is empty!**  
    Tue Dec 10 09:28:30 AEDT 2019::SEVERE::Read process of "input-data-ex.csv" is incomplete!   
    
  - **Case 5: The file indicated contains two row, i.e. one row for heads and one row for data**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv  
    
    *Output*:   
    Tue Dec 10 09:29:38 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:29:38 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:29:38 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:29:38 AEDT 2019::INFO::The input CSV file contains 1 rows and 18 columns.  
    Tue Dec 10 09:29:38 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO  
      
    output:  
    \- row: 1  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: ENTRY_NO=8  
      
    Tue Dec 10 09:29:38 AEDT 2019::INFO::All tasks are done.       
    
  - **Case 6: The file indicated contains multiple rows**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv  
      
    *Output*:   
    Tue Dec 10 09:31:07 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:31:07 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:31:07 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:31:07 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 09:31:07 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=46  
    \- row: 8  
      &nbsp;&nbsp;column: 9  
      &nbsp;&nbsp;data: ENTRY_NO=46  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=45  
      
    Tue Dec 10 09:31:07 AEDT 2019::INFO::All tasks are done.  
    
  - **Case 7: The number of values in a line is more than the heads line**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv  
      
    *Output*:   
    Tue Dec 10 09:35:32 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:35:32 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:35:32 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:35:32 AEDT 2019::SEVERE::The number of values given in line 5 is incorrect  
    Tue Dec 10 09:35:32 AEDT 2019::SEVERE::Read process of "input-data-ex.csv" is incomplete!    
    
  - **Case 8: The number of values in a line is less than the heads line**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -f input-data-ex.csv  
      
    *Output*:   
    Tue Dec 10 09:39:37 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 09:39:37 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 09:39:37 AEDT 2019::INFO::Reading file "input-data-ex.csv" as the source of data ...  
    Tue Dec 10 09:39:37 AEDT 2019::SEVERE::The number of values given in line 28 is incorrect!  
    Tue Dec 10 09:39:37 AEDT 2019::SEVERE::Read process of "input-data-ex.csv" is incomplete!  
    
## Sorting Algorithm  

  **All the outputs of below test cases are semi-automatically verified via the sorting function of Microsoft Excel.**  
  
  - **Case 1: One numerical argument**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO  
    
    *Output*:   
    Tue Dec 10 20:38:34 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 20:38:34 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 20:38:34 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 20:38:34 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 20:38:34 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=46  
    \- row: 8  
      &nbsp;&nbsp;column: 9  
      &nbsp;&nbsp;data: ENTRY_NO=46  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=45  
    
    Tue Dec 10 20:38:34 AEDT 2019::INFO::All tasks are done.   

  - **Case 2: One numerical argument, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO -r
    
    *Output*:   
    Tue Dec 10 20:56:32 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 20:56:32 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 20:56:32 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 20:56:32 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 20:56:32 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO  
      
    output:  
    \- row: 3  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: ENTRY_NO=1  
    \- row: 8  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_NO=1  
    \- row: 4  
      &nbsp;&nbsp;column: 6  
      &nbsp;&nbsp;data: ENTRY_NO=2  
    
    Tue Dec 10 20:56:32 AEDT 2019::INFO::All tasks are done.  
    
  - **Case 3: One string argument**  
    *Input*:   
    $ java -jar sorting-tool.jar -o DESIGNATION  
        
    *Output*:  
    Tue Dec 10 20:58:03 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 20:58:03 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 20:58:03 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 20:58:03 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 20:58:03 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION  
      
    output:  
    \- row: 3  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068  
    \- row: 8  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068  
    \- row: 4  
      &nbsp;&nbsp;column: 6  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 13 111  
      
    Tue Dec 10 20:58:03 AEDT 2019::INFO::All tasks are done.    

  - **Case 4: One string argument, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o DESIGNATION -r  
        
    *Output*:  
    Tue Dec 10 20:59:43 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 20:59:43 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 20:59:43 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 20:59:43 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 20:59:43 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-355  
    \- row: 6  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-355  
    \- row: 4  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-312  
      
    Tue Dec 10 20:59:43 AEDT 2019::INFO::All tasks are done.       

  - **Case 5: One argument, with a whitespace inside its name**  
    *Input*:   
    $ java -jar sorting-tool.jar -o "GW_g__ FieldWB"   
        
    *Output*:   
    Tue Dec 10 21:04:32 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:04:32 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:04:32 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:04:32 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:04:32 AEDT 2019::INFO::The field(s) for sorting: GW_g__ FieldWB  
      
    output:  
    \- row: 4  
      &nbsp;&nbsp;column: 3  
      &nbsp;&nbsp;data: GW_g__ FieldWB=2765  
    \- row: 6  
      &nbsp;&nbsp;column: 10  
      &nbsp;&nbsp;data: GW_g__ FieldWB=2564  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: GW_g__ FieldWB=2270  
    
    Tue Dec 10 21:04:32 AEDT 2019::INFO::All tasks are done.  
    
  - **Case 6: Two numeric arguments**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO EH_cm  
          
    *Output*:  
    Tue Dec 10 21:06:26 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:06:26 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:06:26 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:06:26 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:06:26 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, EH_cm  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=46 EH_cm=160  
    \- row: 8  
      &nbsp;&nbsp;column: 9  
      &nbsp;&nbsp;data: ENTRY_NO=46 EH_cm=150  
    \- row: 6  
      &nbsp;&nbsp;column: 3  
      &nbsp;&nbsp;data: ENTRY_NO=45 EH_cm=128  
    
    Tue Dec 10 21:06:26 AEDT 2019::INFO::All tasks are done.  

  - **Case 7: Two numeric arguments, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO EH_cm -r   
          
    *Output*:   
    Tue Dec 10 21:08:33 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:08:33 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:08:33 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:08:33 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:08:33 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, EH_cm  
      
    output:  
    \- row: 3  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: ENTRY_NO=1 EH_cm=93   
    \- row: 8  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_NO=1 EH_cm=123  
    \- row: 4  
      &nbsp;&nbsp;column: 6  
      &nbsp;&nbsp;data: ENTRY_NO=2 EH_cm=118  
      
    Tue Dec 10 21:08:33 AEDT 2019::INFO::All tasks are done.  
      
  - **Case 8: Two string arguments**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_TYPE DESIGNATION   
            
    *Output*:  
    Tue Dec 10 21:10:19 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:10:19 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:10:19 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:10:19 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:10:19 AEDT 2019::INFO::The field(s) for sorting: ENTRY_TYPE, DESIGNATION  
      
    output:   
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_TYPE=C DESIGNATION=Asgrow CEBU  
    \- row: 4  
      &nbsp;&nbsp;column: 8  
      &nbsp;&nbsp;data: ENTRY_TYPE=C DESIGNATION=Asgrow CEBU  
    \- row: 6  
      &nbsp;&nbsp;column: 3  
      &nbsp;&nbsp;data: ENTRY_TYPE=C DESIGNATION=Asgrow CEBU  
      
    Tue Dec 10 21:10:20 AEDT 2019::INFO::All tasks are done.    

  - **Case 9: Two string arguments, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_TYPE DESIGNATION -r     
            
    *Output*:  
    Tue Dec 10 21:12:28 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:12:28 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:12:28 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:12:28 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:12:28 AEDT 2019::INFO::The field(s) for sorting: ENTRY_TYPE, DESIGNATION  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_TYPE=T DESIGNATION=SLP-355  
    \- row: 6  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_TYPE=T DESIGNATION=SLP-355  
    \- row: 4  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_TYPE=T DESIGNATION=SLP-312  
      
    Tue Dec 10 21:12:28 AEDT 2019::INFO::All tasks are done.  
    
  - **Case 10: One numeric argument and one string argument**  
    *Input*:   
    $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO       
              
    *Output*:  
    Tue Dec 10 21:13:49 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:13:49 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:13:49 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:13:49 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:13:49 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO  
      
    output:  
    \- row: 3  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068 ENTRY_NO=1  
    \- row: 8  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068 ENTRY_NO=1  
    \- row: 4  
      column: 6  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 13 111 ENTRY_NO=2  
      
    Tue Dec 10 21:13:49 AEDT 2019::INFO::All tasks are done.     

  - **Case 11: One numeric argument and one string argument, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO -r         
              
    *Output*:  
    Tue Dec 10 21:15:16 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:15:16 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:15:16 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...   
    Tue Dec 10 21:15:16 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:15:16 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40  
    \- row: 6   
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40  
    \- row: 4  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-312 ENTRY_NO=39   
      
    Tue Dec 10 21:15:16 AEDT 2019::INFO::All tasks are done.    
      
  - **Case 12: One one string argument and one numeric argument**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO DESIGNATION         
                
    *Output*:     
    Tue Dec 10 21:17:24 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:17:24 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:17:24 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:17:24 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:17:24 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, DESIGNATION  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=46 DESIGNATION=P4082W  
    \- row: 8  
      &nbsp;&nbsp;column: 9  
      &nbsp;&nbsp;data: ENTRY_NO=46 DESIGNATION=P4082W  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=45 DESIGNATION=Asgrow CEBU  
      
    Tue Dec 10 21:17:24 AEDT 2019::INFO::All tasks are done.     

  - **Case 13: One one string argument and one numeric argument, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO DESIGNATION -r         
                
    *Output*:     
    Tue Dec 10 21:18:59 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:18:59 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:18:59 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:18:59 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:18:59 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, DESIGNATION  
      
    output:  
    \- row: 3  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: ENTRY_NO=1 DESIGNATION=ARZM 07 068  
    \- row: 8  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_NO=1 DESIGNATION=ARZM 07 068  
    \- row: 4  
      &nbsp;&nbsp;column: 6  
      &nbsp;&nbsp;data: ENTRY_NO=2 DESIGNATION=ARZM 13 111  
    
    Tue Dec 10 21:18:59 AEDT 2019::INFO::All tasks are done.  

  - **Case 14: Two arguments, one of which contains a whitespace in its name**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_NO "GW_g__ FieldWB"           
                
    *Output*:   
    Tue Dec 10 21:22:00 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:22:00 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:22:00 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:22:00 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:22:00 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, GW_g__ FieldWB  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=46 GW_g__ FieldWB=1995   
    \- row: 8  
      &nbsp;&nbsp;column: 9  
      &nbsp;&nbsp;data: ENTRY_NO=46 GW_g__ FieldWB=1800  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_NO=45 GW_g__ FieldWB=2270  
    
    Tue Dec 10 21:22:00 AEDT 2019::INFO::All tasks are done.  
    
    *Input*:   
    $ java -jar sorting-tool.jar -o "GW_g__ FieldWB" ENTRY_NO            
                
    *Output*:   
    Tue Dec 10 21:23:22 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:23:22 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:23:22 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:23:22 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:23:22 AEDT 2019::INFO::The field(s) for sorting: GW_g__ FieldWB, ENTRY_NO  
      
    output:  
    \- row: 4  
      &nbsp;&nbsp;column: 3  
      &nbsp;&nbsp;data: GW_g__ FieldWB=2765 ENTRY_NO=41  
    \- row: 6  
      &nbsp;&nbsp;column: 10  
      &nbsp;&nbsp;data: GW_g__ FieldWB=2564 ENTRY_NO=44  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: GW_g__ FieldWB=2270 ENTRY_NO=45  
      
    Tue Dec 10 21:23:22 AEDT 2019::INFO::All tasks are done.     
    
  - **Case 15: Three arguments**  
    *Input*:   
    $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO EH_cm        
       
    *Output*:    
    Tue Dec 10 21:26:05 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:26:05 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:26:05 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:26:05 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:26:05 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO, EH_cm  
      
    output:  
    \- row: 8  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068 ENTRY_NO=1 EH_cm=123  
    \- row: 3  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 07 068 ENTRY_NO=1 EH_cm=93  
    \- row: 8  
      &nbsp;&nbsp;column: 10  
      &nbsp;&nbsp;data: DESIGNATION=ARZM 13 111 ENTRY_NO=2 EH_cm=145  
      
    Tue Dec 10 21:26:05 AEDT 2019::INFO::All tasks are done.   

  - **Case 16: Three arguments, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o DESIGNATION ENTRY_NO EH_cm -r        
       
    *Output*:    
    Tue Dec 10 21:27:52 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:27:52 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:27:52 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:27:52 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:27:52 AEDT 2019::INFO::The field(s) for sorting: DESIGNATION, ENTRY_NO, EH_cm  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=108  
    \- row: 6  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: DESIGNATION=SLP-355 ENTRY_NO=40 EH_cm=152  
    \- row: 7  
      &nbsp;&nbsp;column: 7  
      &nbsp;&nbsp;data: DESIGNATION=SLP-312 ENTRY_NO=39 EH_cm=122  
      
    Tue Dec 10 21:27:52 AEDT 2019::INFO::All tasks are done.   
    
  - **Case 17: Four arguments**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_TYPE DESIGNATION ENTRY_NO PH_cm EH_cm       
                     
    *Output*:    
    Tue Dec 10 21:29:20 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:29:20 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:29:20 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:29:20 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:29:20 AEDT 2019::INFO::The field(s) for sorting: ENTRY_TYPE, DESIGNATION, ENTRY_NO, PH_cm, EH_cm  
      
    output:  
    \- row: 6  
      &nbsp;&nbsp;column: 3  
      &nbsp;&nbsp;data: ENTRY_TYPE=C DESIGNATION=Asgrow CEBU ENTRY_NO=45 PH_cm=189 EH_cm=128  
    \- row: 4  
      &nbsp;&nbsp;column: 2  
      &nbsp;&nbsp;data: ENTRY_TYPE=C DESIGNATION=Asgrow CEBU ENTRY_NO=45 PH_cm=189 EH_cm=121  
    \- row: 6  
      &nbsp;&nbsp;column: 6  
      &nbsp;&nbsp;data: ENTRY_TYPE=C DESIGNATION=Asgrow CEBU ENTRY_NO=42 PH_cm=183 EH_cm=122  
      
    Tue Dec 10 21:29:20 AEDT 2019::INFO::All tasks are done.  

  - **Case 18: Four arguments, in reverse order**  
    *Input*:   
    $ java -jar sorting-tool.jar -o ENTRY_TYPE DESIGNATION ENTRY_NO PH_cm EH_cm -r        
                     
    *Output*:    
    Tue Dec 10 21:30:54 AEDT 2019::INFO::Welcome to use this sorting tool.  
    Tue Dec 10 21:30:55 AEDT 2019::INFO::Parsing inputted command-line arguments ...  
    Tue Dec 10 21:30:55 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...  
    Tue Dec 10 21:30:55 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.  
    Tue Dec 10 21:30:55 AEDT 2019::INFO::The field(s) for sorting: ENTRY_TYPE, DESIGNATION, ENTRY_NO, PH_cm, EH_cm  
      
    output:  
    \- row: 2  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_TYPE=T DESIGNATION=SLP-355 ENTRY_NO=40 PH_cm=157 EH_cm=108  
    \- row: 6  
      &nbsp;&nbsp;column: 4  
      &nbsp;&nbsp;data: ENTRY_TYPE=T DESIGNATION=SLP-355 ENTRY_NO=40 PH_cm=230 EH_cm=152  
    \- row: 7  
      &nbsp;&nbsp;column: 7  
      &nbsp;&nbsp;data: ENTRY_TYPE=T DESIGNATION=SLP-312 ENTRY_NO=39 PH_cm=197 EH_cm=122  
      
    Tue Dec 10 21:30:55 AEDT 2019::INFO::All tasks are done.   