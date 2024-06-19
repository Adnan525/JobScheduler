# Job Scheduler for Client Side Simulator

The proposed scheduler aims to improve server utilization, execution time, and cost simultaneously, balancing between best fit and worst fit algorithms. The primary focus is on resource utilization.

## Problem Definition

Existing best fit and worst fit algorithms optimize resource utilization and cost separately. However, the proposed algorithm targets customers who want better resource utilization and execution time while maintaining a cost close to or better than best fit. It is suitable for medium data-sensitive applications such as online video streaming, video chatting, online games, or map reduce jobs. Very data-sensitive jobs like operating a driverless vehicle may not be suitable unless they meet specific conditions.

The scheduler primarily benefits consumers with time constraints and budgets, avoiding the need to rent all large servers, which are costly. Resource utilization is improved by using the least number of servers possible, typically at most one server from each type, ensuring high server utilization.

## Algorithm Overview

1. **First Fit Server Check**: The scheduler checks for a first fit server from `system.xml` to run a particular job.
2. **Server Type Usage**: If the server type has been previously used, it minimizes cost and improves waiting time and resource utilization.
3. **Used Server Accommodation**: If a used server can accommodate the job, the scheduler assigns the job to that server to avoid the 60-second boot-up time and additional hourly cost.
4. **Best Fit Server Start**: If no used server can accommodate the job, the scheduler starts the best fit server to minimize cost and improve utilization.
5. **Job Scheduling**: The scheduler considers job submission time, error margin on estimated runtime, and whether the job can be processed within the current hour limit.
   ![ResourceOptimiser](https://github.com/Adnan525/JobScheduler/blob/master/algorithm.png)

## Performance Evaluation

### Cost

- The scheduler is compared against best fit and worst fit algorithms in various test scenarios, showing it provides cost-effective solutions.

### Resource Utilization

- The algorithm consistently optimizes resource utilization compared to worst fit and matches or exceeds best fit performance in most cases.
  ![Resource](https://github.com/Adnan525/JobScheduler/blob/master/resource.png)

## Conclusion

The evaluation charts illustrate that the algorithm optimizes resource utilization better than worst fit and best fit in almost all test cases. Its cost is always better than worst fit and close to best fit, often outperforming best fit when jobs and server types are fewer and most jobs are short.

## Software Requirements

The software is written in Java and requires a Linux bash terminal with Java installed.

### Installation and Setup

1. Open the terminal (`Ctrl+Alt+T`).
2. Add the PPA: `sudo aa-apt-repository ppa:webupd8team/java`.
3. Update and install the installer script: `sudo apt update; sudo apt install oracle-java9-installer`.
4. Check the Java version: `javac -version`.
5. Set Java environment variables: `sudo apt install oracle-java9-set-default`.
6. Extract the submission files.
7. Download and extract the `ds-sim` tar in the same folder.

### Running the Program

1. Compile all classes (e.g., `javac client.java`).
2. Run algorithms:
   - Best fit: `java client -a bf`
   - Worst fit: `java client -a wf`
   - First fit: `java client -a ff`
   - If no algorithm is specified, the default `allToLargest()` runs.
3. Run the newly implemented algorithm: `java client -a optimiseResource`.

### Notes

- Ensure `ds-sim` is downloaded and extracted from `.tar`.
- Run the server with specific `config_simple.xml` or without it.
