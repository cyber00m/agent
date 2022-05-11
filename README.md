# agent

Agent is a software that is installed on each aircraft in our customer's fleet (in each computer that runs the simulator).

The agent collects real-time flight data of the aircraft, sends it to the backend by HTTP protocol, and streams remote control client commands. 

## Model

Thread one:
Data server - the agent functions as a server to the simulator and withdraws data (arguments/variables) that will be saved in our symbol table.
Thread Two:
Client - connects as a client to the simulator and gives flight instructions, allowing the ability to control the plane.

## View

An accessible CLI interface with SSH connection for debug purposes.
Example of use:
java -jar agent.jar aileron -1
java -jar agent.jar shutdown()
java -jar agent.jar print_stream()

##  Controller

when getting remote instructions from the client, values will be smoothed
stream the flight data from the simulator to the backend
throughout the flight, the controller should gather relevant data analytics and have the ability to expand it for future params (SOLID open-close principle)
send analytics to the backend
