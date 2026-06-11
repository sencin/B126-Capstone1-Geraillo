# Load Registration Console App

A Java console application. This project includes a convenient automation script to compile and launch the application directly from the terminal without needing complex IDE setups or build tools.

## How to Run the Application

You can compile and run the entire application by running `chmod +x run.sh` first and `run.sh` script.

### Prerequisites
* Ensure you have the **Java Development Kit (JDK 8 or higher)** installed on your machine.
* Open your terminal:
    * **Windows**: Open **Git Bash** (required to run `.sh` scripts on Windows).
    * **Mac/Linux**: Open the native **Terminal**.

### Quick Start (One Command)
Navigate to the project root folder in Git Bash / Terminal and execute the script:
```bash
./run.sh
```

---

### Troubleshooting & Common Issues

#### 1. "Permission denied" Error
If you get a `bash: ./run.sh: Permission denied` error, it means the script does not have execution rights yet. Fix it by running this command **once**:
```bash
chmod +x run.sh
```
After running that, run `./run.sh` again.
```bash
./run.sh
```
#### 2. "No such file or directory" Error
If Git Bash cannot find the script, make sure your terminal is actually located inside the project folder. You can move into the project folder using the change directory command:
```bash
cd /path/to/your/rootproject
```
*(Tip: In Windows, you can right-click inside your project folder and select **"Git Bash Here"** to automatically open the terminal in the right place).*
