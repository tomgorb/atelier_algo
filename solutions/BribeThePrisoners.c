/*
g++ -std=c++11 -o BribeThePrisoners BribeThePrisoners.c
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <limits>
#include <unordered_map>
using namespace std;

std::vector<int> input_cells;
std::vector<std::vector<int> > input_prisoners;
int inf = std::numeric_limits<int>::max();
int first_cell = 1;
int last_cell;

void cases(string filename) {
	std::vector<int> v_tmp;
	int nb_lines=-1;
	int nb_cells=-1;
	int nb_prisoners=-1;
	ifstream file(filename);
	file >> nb_lines;
	for(int i=0; i<nb_lines; i++) {
		file >> nb_cells >> nb_prisoners;
		input_cells.push_back(nb_cells);
		for(int j=0; j<nb_prisoners; j++) {
			int tmp;
			file >> tmp; v_tmp.push_back(tmp);
		}
		input_prisoners.push_back(v_tmp);
		v_tmp.clear();
	}
	return;
}

int solve_by_d_and_c(int first_cell, int last_cell, std::vector<int> &prisoners,
unordered_map <string, int> &memory) {

	if(first_cell >= last_cell) { return 0; }

	string key = std::to_string(first_cell) + "#" + std::to_string(last_cell);
	if(memory.find(key) != memory.end()) {
		return memory[key];
	}
	int price = last_cell - first_cell;
	int candidate = -1;
	int sol = inf;
	bool b_sol=false;
	int p_size = prisoners.size();
	for (int p=0; p<p_size; p++) {

		if (prisoners[p] >= first_cell && prisoners[p] <= last_cell) {
			candidate = price +
			solve_by_d_and_c(first_cell, prisoners[p]-1, prisoners, memory) +
			solve_by_d_and_c(prisoners[p]+1, last_cell, prisoners, memory);
			if (candidate < sol) {
				sol = candidate;
				b_sol=true;
			}
		}
	}
	if(!b_sol) { sol=0; }
	memory[key] = sol;
	return sol;
}

int solve(int cas) {
	unordered_map <string, int> memory;
	std::vector<int> prisoners;
  prisoners = input_prisoners[cas];
	last_cell = input_cells[cas];
  return solve_by_d_and_c(first_cell, last_cell, prisoners, memory);
}

int main(int argc, char** argv) {
	cases(argv[1]);
	ofstream file(argv[2]);
	int answer;
	int c_size = input_cells.size();
	for(int c=0; c<c_size; c++) {
		answer = solve(c);
		file <<"Case #" <<c+1 <<": " <<answer <<endl;
	}
}
