# Integration Test

## Arguments Parsing

 - **Case 1: No arguments**   
   *Input*:   
   $ java -jar SortingTool.jar   
   
   *Output*:  
   Sun Dec 08 20:40:06 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
   Sun Dec 08 20:40:06 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
   Sun Dec 08 20:40:06 AEDT 2019::SEVERE::diversity.arrays.ArgsParser::\<init>::**No arguments are given for sorting!**  
   
 - **Case 2: One of arguments is not a head in the csv file**  
   *Input*:   
   $ java -jar SortingTool.jar TryMe
  
   *Output*:  
   Sun Dec 08 20:51:02 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
   Sun Dec 08 20:51:02 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
   Sun Dec 08 20:51:02 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
   Sun Dec 08 20:51:03 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::The input CSV file contains 92 rows and 18 columns.  
   Sun Dec 08 20:51:03 AEDT 2019::SEVERE::diversity.arrays.ArgsParser::areSortedFieldsLegal::**No field named "TryMe" can be used for sorting!**  
   
   *Input*:   
   $ java -jar SortingTool.jar ENTRY_NO EH_cm TryMe PH_cm
     
   *Output*:  
   Sun Dec 08 20:52:51 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
   Sun Dec 08 20:52:51 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
   Sun Dec 08 20:52:51 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
   Sun Dec 08 20:52:51 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::The input CSV file contains 92 rows and 18 columns.  
   Sun Dec 08 20:52:51 AEDT 2019::SEVERE::diversity.arrays.ArgsParser::areSortedFieldsLegal::**No field named "TryMe" can be used for sorting!**  
   
 - **Case 3: All arguments are the heads available in the csv file**  
   *Input*:   
   $ java -jar SortingTool.jar ENTRY_NO EH_cm PH_cm  
   
   *Output*:  
   Sun Dec 08 20:55:45 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
   Sun Dec 08 20:55:45 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
   Sun Dec 08 20:55:45 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
   Sun Dec 08 20:55:45 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::The input CSV file contains 92 rows and 18 columns.  
   Sun Dec 08 20:55:45 AEDT 2019::INFO::diversity.arrays.DeepCompare::\<init>::The field(s) for sorting: ENTRY_NO, EH_cm, PH_cm  
   
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
   
   Sun Dec 08 20:55:45 AEDT 2019::INFO::diversity.arrays.SortingTool::main::**All tasks are done.**   
   
## CSV File Reading  

  - **Case 1: There is no other file in the same folder as SortingTool.jar**   
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
    
    *Output*:  
    Sun Dec 08 21:12:25 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:12:25 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:12:25 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:12:25 AEDT 2019::SEVERE::diversity.arrays.FileHolder::\<init>::**Input file "input-data.csv" does not exist!**  
    
  - **Case 2: There is no file named "input-data.csv" in the same folder as SortingTool.jar**  
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
    
    *Output*:   
    Sun Dec 08 21:16:30 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:16:30 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:16:30 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:16:30 AEDT 2019::SEVERE::diversity.arrays.FileHolder::\<init>::**Input file "input-data.csv" does not exist!**  
    
  - **Case 3: The content of the file "input-data.csv" is empty**  
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
  
    *Output*:   
    Sun Dec 08 21:20:18 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:20:18 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:20:18 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:20:18 AEDT 2019::SEVERE::diversity.arrays.FileHolder::isDataComplete::**Data read from file "input-data.csv" is empty!**  
    Sun Dec 08 21:20:18 AEDT 2019::SEVERE::diversity.arrays.FileHolder::\<init>::**Read process of "input-data.csv" is incomplete!**  
    
  - **Case 4: The file "input-data.csv" only contains one row, i.e. the heads**  
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
    
    *Output*:   
    Sun Dec 08 21:22:33 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:22:33 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:22:33 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:22:33 AEDT 2019::SEVERE::diversity.arrays.FileHolder::isDataComplete::**Data read from file "input-data.csv" is empty!**  
    Sun Dec 08 21:22:33 AEDT 2019::SEVERE::diversity.arrays.FileHolder::\<init>::**Read process of "input-data.csv" is incomplete!**  
    
  - **Case 5: The file "input-data.csv" contains two row, i.e. one row for heads and one row for data**  
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
    
    *Output*:   
    Sun Dec 08 21:25:46 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:25:46 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:25:46 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:25:46 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::The input CSV file contains 1 rows and 18 columns.  
    Sun Dec 08 21:25:46 AEDT 2019::INFO::diversity.arrays.DeepCompare::\<init>::The field(s) for sorting: ENTRY_NO  
    
    output:  
    \- row: 1  
      &nbsp;&nbsp;column: 1  
      &nbsp;&nbsp;data: ENTRY_NO=8  
      
    Sun Dec 08 21:25:46 AEDT 2019::INFO::diversity.arrays.SortingTool::main::**All tasks are done.**     
    
  - **Case 6: The file "input-data.csv" contains multiple rows**  
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
      
    *Output*:   
    Sun Dec 08 21:30:03 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:30:03 AEDT 2019::INFO::diversity.arrays.ArgsParser::\<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:30:03 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:30:03 AEDT 2019::INFO::diversity.arrays.FileHolder::\<init>::The input CSV file contains 92 rows and 18 columns.  
    Sun Dec 08 21:30:03 AEDT 2019::INFO::diversity.arrays.DeepCompare::\<init>::The field(s) for sorting: ENTRY_NO  
    
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
      
    Sun Dec 08 21:30:03 AEDT 2019::INFO::diversity.arrays.SortingTool::main::**All tasks are done.**  
    
  - **Case 6: The number of commas of one data line is different with the heads line**  
    *Input*:   
    $ java -jar SortingTool.jar ENTRY_NO  
        
    *Output*:   
    Sun Dec 08 21:36:32 AEDT 2019::INFO::diversity.arrays.SortingTool::main::Welcome to use this sorting tool.  
    Sun Dec 08 21:36:32 AEDT 2019::INFO::diversity.arrays.ArgsParser::<init>::Parsing inputted command-line arguments ...  
    Sun Dec 08 21:36:32 AEDT 2019::INFO::diversity.arrays.FileHolder::<init>::Reading file "input-data.csv" as the source of data ...  
    Sun Dec 08 21:36:32 AEDT 2019::SEVERE::diversity.arrays.FileHolder::isDataComplete::**The number of values given in line *25* is incorrect**  
    Sun Dec 08 21:36:32 AEDT 2019::SEVERE::diversity.arrays.FileHolder::<init>::**Read process of "input-data.csv" is incomplete!**  
    
## Sorting Algorithm  
